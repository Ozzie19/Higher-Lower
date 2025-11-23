/**
 * Represents a single playing card in a standard deck.
 * A card consists of a {@link Rank} and a {@link Suit}.
 *
 * This class is immutable: once created, the rank and suit cannot change.
 */
public class Card {

    private final Rank rank;
    private final Suit suit;

    /**
     * Constructs a new Card with the given rank and suit.
     *
     * @param rank the rank of the card (e.g., ACE, KING, TEN)
     * @param suit the suit of the card (e.g., HEARTS, SPADES)
     */
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Returns the rank of this card.
     *
     * @return the card's rank
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Returns the suit of this card.
     *
     * @return the card's suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Returns a human-readable representation of the card.
     * Example: "Ace of Hearts" or "10 of Clubs".
     *
     * @return a string representation of the card
     */
    @Override
    public String toString() {
        return rank.toString() + " of " + suit.toString();
    }
}
