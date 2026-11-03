package cat.itacademy.solid.d.service;

import cat.itacademy.solid.d.exception.BookingAccessDeniedException;
import cat.itacademy.solid.d.model.Booking;
import cat.itacademy.solid.d.repository.Repository;

import java.time.Clock;
import java.time.LocalDateTime;

public class BookingService {

    private final Repository repository;
    private Clock clock;

    public BookingService(Repository repository, Clock clock) {
        this.repository = repository;
        this.clock = clock;
    }

    public BookingService(Repository repository) {
        this.repository = repository;
        this.clock = Clock.systemDefaultZone();
    }

    public void cancelBooking(String customerId, Long bookingId) {
        Booking booking = repository.findById(bookingId)
                .orElseThrow(() -> new IllegalStateException("Booking not found"));

        if (!booking.belongsTo(customerId)) {
            throw new BookingAccessDeniedException(customerId, bookingId);
        }

        LocalDateTime now = LocalDateTime.now(clock);

        booking.cancel(now);
        repository.save(booking);
    }
}
