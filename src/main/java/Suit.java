/**
 * Represents the four suits in a standard deck of playing cards.
 * <p>
 * Each {@code Suit} has both a human-readable name (e.g., "Hearts")
 * and a symbolic Unicode character (e.g., "♥"). The symbol support
 * allows for enhanced display options in the UI and provides
 * future flexibility should the game introduce graphical elements.
 * </p>
 *
 * <h2>Available Suits</h2>
 * <ul>
 *     <li>Hearts (♥)</li>
 *     <li>Diamonds (♦)</li>
 *     <li>Clubs (♣)</li>
 *     <li>Spades (♠)</li>
 * </ul>
 *
 * <p>
 * The {@link #toString()} method returns the English name of the suit,
 * while {@link #toStringSymbol()} returns the corresponding Unicode symbol.
 * </p>
 */
public enum Suit {

    HEARTS("Hearts", "♥"),
    DIAMONDS("Diamonds", "♦"),
    CLUBS("Clubs", "♣"),
    SPADES("Spades", "♠");

    /** The human-readable name of the suit. */
    private final String suit;

    /** The Unicode symbol associated with the suit. */
    private final String symbol;

    /**
     * Constructs a suit with the given name and symbol.
     *
     * @param suit   the name of the suit (e.g., "Hearts")
     * @param symbol the Unicode suit symbol (e.g., "♥")
     */
    Suit(String suit, String symbol) {
        this.suit = suit;
        this.symbol = symbol;
    }

    /**
     * Returns the English name of the suit.
     *
     * @return the suit's name
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Returns the Unicode symbol representing the suit.
     * Useful for more graphical output or GUI extensions.
     *
     * @return the suit's Unicode symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Returns the suit name as the default string representation.
     * <p>
     * Example: "Hearts", "Clubs".
     * </p>
     *
     * @return the suit name
     */
    @Override
    public String toString() {
        return suit;
    }

    /**
     * Returns only the symbolic representation of the suit.
     * <p>
     * Example: "♥", "♣".
     * </p>
     *
     * @return the suit symbol
     */
    public String toStringSymbol() {
        return symbol;
    }
}
