package cat.itacademy.solid.l.src;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CharacterTest {

    @Test
    void WarriorShouldTakeDamage() {
        Warrior warrior = new Warrior("Ares");
        warrior.takeDamage(12);
        assertThat(warrior.getPoints()).isEqualTo(94);
    }

}