/**
 * Represents a player in the Higher or Lower game.
 * <p>
 * A {@code Player} stores a user's name, remaining lives, and current score.
 * Each game session creates a new player instance, and the values are updated
 * as the player makes guesses during the game.
 * </p>
 *
 * <h2>Default Values</h2>
 * <ul>
 *     <li>Lives: 3</li>
 *     <li>Score: 0</li>
 * </ul>
 *
 * <p>
 * This class is intentionally simple and acts as a data container with a few
 * state-modifying methods used by the {@link GameEngine}.
 * </p>
 */
public class Player {

    /** The player's name. */
    private String name;

    /** The number of lives the player has remaining. */
    private int lives;

    /** The player's current score. */
    private int score;

    /**
     * Creates a new {@code Player} with the given name, 3 lives,
     * and an initial score of 0.
     *
     * @param name the player's name
     */
    public Player(String name) {
        this.name = name;
        this.lives = 3;
        this.score = 0;
    }

    /**
     * Returns the player's name.
     *
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the player's name.
     * <p>
     * Although not required in normal gameplay, this method is provided for
     * completeness and potential future extension.
     * </p>
     *
     * @param name the new player name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the number of lives the player currently has.
     *
     * @return the player's remaining lives
     */
    public int getLives() {
        return lives;
    }

    /**
     * Sets the number of lives for the player.
     * <p>
     * This method is not used in normal gameplay but is included to support
     * potential custom modes or testing flexibility.
     * </p>
     *
     * @param lives the number of lives to assign
     */
    public void setLives(int lives) {
        this.lives = lives;
    }

    /**
     * Returns the player's current score.
     *
     * @return the player's score
     */
    public int getScore() {
        return score;
    }

    /**
     * Decreases the player's remaining lives by one.
     * No lower bound is enforced here; the game logic checks
     * {@link #isAlive()} to determine if the player can continue.
     */
    public void loseLife() {
        lives--;
    }

    /**
     * Increases the player's score by one.
     * Used when the player makes a correct guess.
     */
    public void increaseScore() {
        score++;
    }

    /**
     * Returns whether the player is still alive.
     * A player is considered alive if they have more than zero lives.
     *
     * @return {@code true} if the player has remaining lives, otherwise {@code false}
     */
    public boolean isAlive() {
        return lives > 0;
    }
}
