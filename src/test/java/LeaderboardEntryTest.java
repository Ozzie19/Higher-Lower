import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LeaderboardEntryTest {

    @Test
    void testConstructorSetsFieldsCorrectly() {
        LeaderboardEntry entry = new LeaderboardEntry("Alice", 10);

        assertEquals("Alice", entry.getName());
        assertEquals(10, entry.getScore());
    }

    @Test
    void testToStringFormat() {
        LeaderboardEntry entry = new LeaderboardEntry("Bob", 25);

        assertEquals("Bob - 25", entry.toString());
    }
}
