package cat.itacademy.solid.d.service;

import cat.itacademy.solid.d.exception.BookingAccessDeniedException;
import cat.itacademy.solid.d.exception.CancellationPeriodExpiredException;
import cat.itacademy.solid.d.model.Booking;
import cat.itacademy.solid.d.model.BookingStatus;
import cat.itacademy.solid.d.repository.H2BookingRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {

    private H2BookingRepository repository;
    private BookingService service;

    @BeforeEach
    void setUp() {
        repository = new H2BookingRepository(
                "jdbc:h2:mem:" + UUID.randomUUID()
        );
        service = new BookingService(repository);
    }

    @AfterEach
    void tearDown() {
        repository.close();
    }

    @Test
    void ownerShouldCancelBookingMoreThan24HoursBeforeStart() {
        Long id = save(LocalDateTime.now().plusHours(48));

        service.cancelBooking("CUSTOMER-001", id);

        Booking saved = repository.findById(id).orElseThrow();
        assertEquals(BookingStatus.CANCELLED, saved.getStatus());
        assertNotNull(saved.getCancelledAt());
    }

    @Test
    void customerShouldNotCancelAnotherCustomersBooking() {
        Long id = save(LocalDateTime.now().plusHours(48));

        assertThrows(
                BookingAccessDeniedException.class,
                () -> service.cancelBooking("CUSTOMER-002", id)
        );
    }

    @Test
    void ownerShouldNotCancelLessThan24HoursBeforeStart() {
        Long id = save(LocalDateTime.now().plusHours(2));

        assertThrows(
                CancellationPeriodExpiredException.class,
                () -> service.cancelBooking("CUSTOMER-001", id)
        );
    }

    @Test
    void shouldFailWhenBookingDoesNotExist() {
        assertThrows(
                IllegalStateException.class,
                () -> service.cancelBooking("CUSTOMER-001", 999L)
        );
    }

    @Test
    void ownerShouldCancelExactly24HoursBeforeStart() {
        // Volem provar el límit exacte, però el servei llegeix el seu propi LocalDateTime.now().
        // Quan s'executa, ja han passat uns mil·lisegons i som a "24 h menys una mica": la reserva
        // queda fora de termini i el test falla, encara que la regla diu que el límit és vàlid.

        LocalDateTime fixedNow = LocalDateTime.of(2026, 6, 1, 12, 0, 0);

        Clock fixedClock = Clock.fixed(
                fixedNow.atZone(ZoneId.systemDefault()).toInstant(),
                ZoneId.systemDefault()
        );

        BookingService serviceWithFixedClock = new BookingService(repository, fixedClock);

        Long id = save(LocalDateTime.now().plusHours(24));

        assertDoesNotThrow(() -> serviceWithFixedClock.cancelBooking("CUSTOMER-001", id));
    }

    private Long save(LocalDateTime startsAt) {
        return repository.save(
                new Booking("CUSTOMER-001", "ROOM-1", startsAt, startsAt.plusHours(1))
        ).getId();
    }
}
