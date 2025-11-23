import java.util.Scanner;

/**
 * Entry point for the Higher or Lower game application.
 * <p>
 * The {@code Main} class is responsible for initialising the program,
 * handling the main game loop, and allowing the player to replay multiple
 * rounds. It also manages the shared {@link Leaderboard} instance used
 * to persist and display scores across games.
 * </p>
 */
public class Main {

    /**
     * Launches the Higher or Lower game.
     * <p>
     * The method performs the following steps:
     * </p>
     * <ol>
     *     <li>Creates a {@link Leaderboard} to store and load persistent scores.</li>
     *     <li>Enters a loop where a new {@link GameEngine} is created for each game.</li>
     *     <li>Runs the game and retrieves the resulting {@link Player} object.</li>
     *     <li>Adds the player's score to the leaderboard and prints the updated standings.</li>
     *     <li>Prompts the user to play again or exit the program.</li>
     * </ol>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Leaderboard leaderboard = new Leaderboard();

        while (true) {

            GameEngine engine = new GameEngine();
            Player p = engine.run();

            leaderboard.addEntry(p.getName(), p.getScore());
            leaderboard.printLeaderboard();

            System.out.println("\nWould you like to play again? (Y/N)");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (!choice.startsWith("y")) {
                System.out.println("Thanks for playing!");
                break;
            }

            System.out.println("\nStarting a new game...\n");
        }
    }
}
