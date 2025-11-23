import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a standard deck of 52 playing cards.
 * <p>
 * A {@code Deck} contains one card of each combination of {@link Rank} and {@link Suit}.
 * When constructed, the deck is automatically shuffled.
 * Cards are drawn from the "top" of the deck (index 0), and removed as they are drawn.
 * </p>
 */
public class Deck {

    /** Internal list of cards representing the deck. */
    private final ArrayList<Card> cards;

    /**
     * Constructs a new shuffled deck containing all 52 unique cards
     * from the standard suits and ranks.
     */
    public Deck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
        shuffle();
    }

    /**
     * Randomly shuffles the deck using {@link Collections#shuffle(java.util.List)}.
     * <p>
     * This method is private because shuffling should only occur on deck creation.
     * </p>
     */
    private void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Draws the next card from the top of the deck.
     * The drawn card is removed from the deck.
     *
     * @return the next {@link Card} in the deck
     * @throws IndexOutOfBoundsException if the deck is empty
     */
    public Card drawCard() {
        return cards.remove(0);
    }

    /**
     * Checks whether the deck has no remaining cards.
     *
     * @return {@code true} if all cards have been drawn, otherwise {@code false}
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    /**
     * Returns the number of cards currently remaining in the deck.
     *
     * @return the size of the deck
     */
    public int getSize() {
        return cards.size();
    }
}
