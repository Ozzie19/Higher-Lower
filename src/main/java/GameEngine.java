import java.util.Scanner;

/**
 * The core controller for the Higher or Lower game.
 * <p>
 * The {@code GameEngine} manages user interaction, game flow, card drawing,
 * score/lives updates, and delegates card/leaderboard logic to other classes.
 * </p>
 *
 * <h2>Game Rules</h2>
 * <ul>
 *   <li>The player begins with 3 lives.</li>
 *   <li>A starting card is shown to the player.</li>
 *   <li>The player guesses whether the next card will be higher or lower.</li>
 *   <li>If correct, the player earns 1 point.</li>
 *   <li>If incorrect, the player loses a life.</li>
 *   <li>If the cards have equal rank, no points or lives are changed.</li>
 *   <li>The game ends when the deck runs out of cards or the player loses all lives.</li>
 * </ul>
 *
 * <p>
 * This class is responsible only for orchestrating the game loop and user input,
 * following the Single Responsibility Principle.
 * </p>
 */
public class GameEngine {

    private Deck deck;
    private Card currentCard;
    private Scanner scanner;
    private Player player;

    /**
     * Constructs a new {@code GameEngine}, initialising a fresh shuffled deck,
     * drawing the first card, and creating a {@link Scanner} for user input.
     */
    public GameEngine() {
        deck = new Deck();
        currentCard = deck.drawCard();
        scanner = new Scanner(System.in);
    }

    /**
     * Prompts the user for a guess of "higher" or "lower".
     * Accepts both full words and abbreviations (e.g., "h", "H", "higher").
     * <p>
     * The method will continue prompting until valid input is received.
     * </p>
     *
     * @return the player's choice as a normalised string: either {@code "higher"} or {@code "lower"}
     */
    private String getPlayerChoice() {
        while (true) {
            System.out.println("Higher or Lower? (H/L)");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.startsWith("h")) {
                return "higher";
            }

            if (input.startsWith("l")) {
                return "lower";
            }

            System.out.println("Invalid input. Please type Higher or Lower.");
        }
    }

    /**
     * Runs the Higher or Lower game loop.
     * <p>
     * This method:
     * </p>
     * <ul>
     *     <li>Prompts the user for their name.</li>
     *     <li>Displays the current card.</li>
     *     <li>Reads and validates the player's guess.</li>
     *     <li>Draws the next card and compares ranks.</li>
     *     <li>Adjusts score or lives depending on correctness.</li>
     *     <li>Continues until the deck is empty or the player runs out of lives.</li>
     * </ul>
     *
     * @return the final {@link Player} object, containing name, score and remaining lives,
     *         which can be used by other components (e.g., leaderboard)
     */
    public Player run() {
        System.out.println("Welcome to Higher or Lower!");
        System.out.println("What is your name?");
        String input = scanner.nextLine().trim();
        player = new Player(input);
        System.out.println("Welcome " + player.getName() + "! You have " + player.getLives() + " lives.");

        while (!deck.isEmpty() && player.isAlive()) {

            System.out.println("Current card: " + currentCard);
            String choice = getPlayerChoice();

            // Draw next card AFTER the guess
            Card nextCard = deck.drawCard();
            System.out.println("Next card: " + nextCard);

            boolean isHigher = nextCard.getRank().getValue() > currentCard.getRank().getValue();
            boolean isLower  = nextCard.getRank().getValue() < currentCard.getRank().getValue();
            boolean isEqual  = nextCard.getRank().getValue() == currentCard.getRank().getValue();

            boolean correctGuess =
                    (choice.equals("higher") && isHigher) ||
                            (choice.equals("lower")  && isLower);

            if (correctGuess) {
                player.increaseScore();
                System.out.println("Correct! Score: " + player.getScore());
                currentCard = nextCard;
            } else {
                if (isEqual) {
                    System.out.println("Cards are the same. No points awarded!");
                    currentCard = nextCard;
                    continue;
                } else {
                    player.loseLife();
                    System.out.println("Wrong! Lives remaining: " + player.getLives());

                    if (!player.isAlive()) {
                        break; // Player is out of lives
                    }

                    currentCard = nextCard;
                    continue;
                }
            }
        }

        System.out.println("Game over! Final score: " + player.getScore());
        return player;
    }
}
