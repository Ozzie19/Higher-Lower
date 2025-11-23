import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    private Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();
    }

    // -----------------------
    // 1. Deck initialisation
    // -----------------------

    @Test
    void testDeckStartsWith52Cards() {
        assertEquals(52, deck.getSize(), "A new deck should start with 52 cards.");
    }

    @Test
    void testDeckContainsAllUniqueCards() {
        Set<String> uniqueCards = new HashSet<>();

        while (!deck.isEmpty()) {
            Card card = deck.drawCard();
            String representation = card.getRank() + "-" + card.getSuit();
            uniqueCards.add(representation);
        }

        assertEquals(52, uniqueCards.size(), "A deck should contain 52 unique cards.");
    }

    // -----------------------
    // 2. Drawing cards
    // -----------------------

    @Test
    void testDrawCardReducesSize() {
        int originalSize = deck.getSize();
        deck.drawCard();
        assertEquals(originalSize - 1, deck.getSize(), "Drawing a card should reduce deck size by 1.");
    }

    @Test
    void testDrawReturnsACard() {
        Card card = deck.drawCard();
        assertNotNull(card, "drawCard() should never return null.");
    }

    @Test
    void testDeckEventuallyBecomesEmpty() {
        while (!deck.isEmpty()) {
            deck.drawCard();
        }
        assertTrue(deck.isEmpty(), "Deck should be empty after drawing all cards.");
    }

    @Test
    void testDrawingFromEmptyDeckThrowsException() {
        // Exhaust the deck
        while (!deck.isEmpty()) {
            deck.drawCard();
        }

        // Now drawing again should throw an error
        assertThrows(IndexOutOfBoundsException.class, () -> deck.drawCard());
    }

    // -----------------------
    // 3. Shuffling
    // -----------------------

    @Test
    void testShuffleChangesOrderMostOfTheTime() {
        Deck anotherDeck = new Deck(); // independently shuffled deck

        Card firstFromDeck = deck.drawCard();
        Card firstFromOther = anotherDeck.drawCard();

        // This is a probabilistic test — VERY unlikely to fail
        assertNotEquals(firstFromDeck.toString(),
                firstFromOther.toString(),
                "Two new decks should usually be shuffled differently.");
    }

    @Test
    void testShuffleDoesNotChangeCardCount() {
        int before = deck.getSize();
        // Reshuffle by creating a new deck (shuffle happens in constructor)
        Deck reshuffled = new Deck();
        int after = reshuffled.getSize();

        assertEquals(before, after,
                "Shuffling should not change the number of cards in the deck.");
    }
}
