package cat.itacademy.solid.l.src;

public class Ghost extends Character {

    private int points;
    private String name;

    public Ghost( String name) {
        this.points = 100;
        this.name = name;
    }

    @Override
    public void attack() {
        System.out.println("The ghost casts a spooky spell.");
    }

    @Override
    public String takeDamage(int points) {
        return "A ghost cannot take physical damage!";
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
