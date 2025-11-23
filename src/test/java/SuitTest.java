import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SuitTest {

    @Test
    void testSuitCount() {
        assertEquals(4, Suit.values().length,
                "There should be exactly 4 suits.");
    }

    @Test
    void testSuitNames() {
        assertEquals("Hearts", Suit.HEARTS.getSuit());
        assertEquals("Diamonds", Suit.DIAMONDS.getSuit());
        assertEquals("Clubs", Suit.CLUBS.getSuit());
        assertEquals("Spades", Suit.SPADES.getSuit());
    }

    @Test
    void testSuitSymbols() {
        assertEquals("♥", Suit.HEARTS.getSymbol());
        assertEquals("♦", Suit.DIAMONDS.getSymbol());
        assertEquals("♣", Suit.CLUBS.getSymbol());
        assertEquals("♠", Suit.SPADES.getSymbol());
    }

    @Test
    void testToStringReturnsName() {
        assertEquals("Hearts", Suit.HEARTS.toString());
        assertEquals("Diamonds", Suit.DIAMONDS.toString());
        assertEquals("Clubs", Suit.CLUBS.toString());
        assertEquals("Spades", Suit.SPADES.toString());
    }

    @Test
    void testToStringSymbolMethod() {
        assertEquals("♥", Suit.HEARTS.toStringSymbol());
        assertEquals("♦", Suit.DIAMONDS.toStringSymbol());
        assertEquals("♣", Suit.CLUBS.toStringSymbol());
        assertEquals("♠", Suit.SPADES.toStringSymbol());
    }

    @Test
    void testToStringNotNull() {
        for (Suit s : Suit.values()) {
            assertNotNull(s.toString(), "Suit.toString() should never return null");
            assertNotNull(s.toStringSymbol(), "Suit.toStringSymbol() should never return null");
        }
    }
}
