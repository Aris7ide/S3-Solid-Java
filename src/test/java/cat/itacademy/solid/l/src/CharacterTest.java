package cat.itacademy.solid.l.src;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CharacterTest {

    @Test
    void GhostShouldNotTakeDamage() {
        Ghost ghost = new Ghost("Booo");
        ghost.takeDamage(12);
        assertThat(ghost.takeDamage(12)).isEqualTo("A ghost cannot take physical damage!");
        assertThat(ghost.getPoints()).isEqualTo(100);
    }

    @Test
    void WarriorShouldTakeDamage() {
        Warrior warrior = new Warrior("Ares");
        warrior.takeDamage(12);
        assertThat(warrior.getPoints()).isEqualTo(94);
    }

}