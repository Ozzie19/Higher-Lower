/**
 * Represents the rank (value) of a playing card in a standard deck.
 * <p>
 * Each rank has an associated numerical value from 1 (Ace) to 13 (King).
 * These values are used by the game logic to compare cards when determining
 * whether one card is higher or lower than another.
 * </p>
 *
 * <h2>Rank Values</h2>
 * <ul>
 *     <li>Ace = 1</li>
 *     <li>2–10 = their numeric values</li>
 *     <li>Jack = 11</li>
 *     <li>Queen = 12</li>
 *     <li>King = 13</li>
 * </ul>
 *
 * <p>
 * The enum also provides a custom {@link #toString()} implementation that
 * returns human-readable names for face cards while using numeric values
 * for the ranks Two through Ten.
 * </p>
 */
public enum Rank {

    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    /** The numeric value of this rank, used for comparisons. */
    private final int value;

    /**
     * Constructs a {@code Rank} with the specified numeric value.
     *
     * @param value the rank's numeric value
     */
    Rank(int value) {
        this.value = value;
    }

    /**
     * Returns the numeric value of this rank.
     *
     * @return the value assigned to this rank
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns a human-readable representation of the rank.
     * <p>
     * Face cards and Ace return:
     * </p>
     * <ul>
     *     <li>"Ace"</li>
     *     <li>"Jack"</li>
     *     <li>"Queen"</li>
     *     <li>"King"</li>
     * </ul>
     * Number ranks return their numeric value as a string (e.g., "2", "7", "10").
     *
     * @return a readable version of the rank's name
     */
    @Override
    public String toString() {
        return switch (this) {
            case ACE -> "Ace";
            case JACK -> "Jack";
            case QUEEN -> "Queen";
            case KING -> "King";
            default -> String.valueOf(value);
        };
    }
}
