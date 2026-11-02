package cat.itacademy.solid.o.src;

public class InstrumentPlayer {
    public String play(Instrument instrument) {
        if (instrument != null) {
            return instrument.play();
        } else {
            return "Instrument is null";
        }
    }
}
