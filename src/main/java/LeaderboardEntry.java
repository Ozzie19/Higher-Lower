/**
 * Represents a single entry in the leaderboard.
 * <p>
 * A {@code LeaderboardEntry} stores a player's name and final score.
 * Entries are simple immutable data objects used by the {@link Leaderboard}
 * class to display and persist high-score information.
 * </p>
 */
public class LeaderboardEntry {

    /** The player's name recorded on the leaderboard. */
    private final String name;

    /** The player's final score. */
    private final int score;

    /**
     * Creates a new leaderboard entry with the given player name and score.
     *
     * @param name  the player's name
     * @param score the score achieved by the player
     */
    public LeaderboardEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * Returns the player's name.
     *
     * @return the name stored in this leaderboard entry
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the player's score.
     *
     * @return the score stored in this leaderboard entry
     */
    public int getScore() {
        return score;
    }

    /**
     * Returns a human-readable representation of the entry in the format:
     * <pre>
     *     name - score
     * </pre>
     * For example:
     * <pre>
     *     Alice - 14
     * </pre>
     *
     * @return a formatted string containing the player's name and score
     */
    @Override
    public String toString() {
        return name + " - " + score;
    }
}
