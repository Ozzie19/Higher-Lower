import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RankTest {

    @Test
    void testRankValues() {
        assertEquals(1, Rank.ACE.getValue());
        assertEquals(11, Rank.JACK.getValue());
        assertEquals(12, Rank.QUEEN.getValue());
        assertEquals(13, Rank.KING.getValue());
    }

    @Test
    void testRankCount() {
        assertEquals(13, Rank.values().length);
    }

    @Test
    void testRankToStringNotNull() {
        for (Rank r : Rank.values()) {
            assertNotNull(r.toString(), "Rank toString() should not return null");
        }
    }
}
