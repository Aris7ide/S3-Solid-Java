package cat.itacademy.solid.l.src;

public class Character {
    public void attack() {
        System.out.println("The character attacks with a weapon.");
    }

    public String takeDamage(int points) {
        return "The character takes " + points + " points of damage.";
    }
}
