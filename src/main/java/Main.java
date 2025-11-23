import java.util.Scanner;

public class Main {
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
