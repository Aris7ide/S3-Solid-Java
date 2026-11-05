package cat.itacademy.solid.l.src;

public class Warrior extends Character implements TakeDamage {

    private int points;
    private String name;

    public Warrior(String name) {
        this.points = 100;
        this.name = name;
    }

    @Override
    public void attack() {
        System.out.println("The warrior strikes with a sword.");
    }

    @Override
    public void takeDamage(int points) {
        this.points = this.points - (points/2);
        System.out.println("The warrior resists and only takes " + (points / 2) + " points of damage.");
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
