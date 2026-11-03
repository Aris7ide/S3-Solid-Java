package cat.itacademy.solid.i.src;

public class AirConditioner implements OnOff , Air {

    @Override
    public void turnOn() {
        System.out.println("AirConditioner is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("AirConditioner is OFF");
    }

    @Override
    public void heat() {
        System.out.println("AirConditioner is heating.");
    }

    @Override
    public void cool() {
        System.out.println("AirConditioner is cooling.");
    }
}

