package cat.itacademy.solid.o.src;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InstrumentPlayerTest {

    @Test
    void shouldPlayGuitar() {
        Guitar guitar = new Guitar();
        InstrumentPlayer instrumentPlayer = new InstrumentPlayer();
        assertThat(instrumentPlayer.play(guitar)).isEqualTo("Guitar is playing");
    };

    @Test
    void shouldGiveError() {
        InstrumentPlayer instrumentPlayer = new InstrumentPlayer();
        assertThat(instrumentPlayer.play(null)).isEqualTo("Instrument is null");
    }

}