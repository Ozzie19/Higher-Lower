import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    void testPlayerInitialState() {
        Player p = new Player("Ozgur");

        assertEquals("Ozgur", p.getName());
        assertEquals(3, p.getLives());
        assertEquals(0, p.getScore());
        assertTrue(p.isAlive());
    }

    @Test
    void testSetName() {
        Player p = new Player("OldName");
        p.setName("NewName");
        assertEquals("NewName", p.getName());
    }

    @Test
    void testIncreaseScore() {
        Player p = new Player("Test");
        p.increaseScore();
        assertEquals(1, p.getScore());

        p.increaseScore();
        assertEquals(2, p.getScore());
    }

    @Test
    void testLoseLife() {
        Player p = new Player("Test");

        p.loseLife();
        assertEquals(2, p.getLives());

        p.loseLife();
        assertEquals(1, p.getLives());
    }

    @Test
    void testSetLives() {
        Player p = new Player("Test");
        p.setLives(10);
        assertEquals(10, p.getLives());
    }

    @Test
    void testIsAliveTrue() {
        Player p = new Player("Test");
        assertTrue(p.isAlive(), "Player should be alive at 3 lives");
    }

    @Test
    void testIsAliveFalse() {
        Player p = new Player("Test");

        p.loseLife();
        p.loseLife();
        p.loseLife();

        assertFalse(p.isAlive(), "Player should be dead after losing all lives");
    }
}
