import java.util.Scanner;

public class GameEngine {

    private Deck deck;
    private Card currentCard;
    private Scanner scanner;
    private Player player;

    public GameEngine() {
        deck = new Deck();
        currentCard = deck.drawCard();
        scanner = new Scanner(System.in);
    }

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
                            break; // game over
                        }

                        // continue game with nextCard even after wrong guess
                        currentCard = nextCard;
                        continue;
                    }

            }

        }

        System.out.println("Game over! Final score: " + player.getScore());
        return player;
    }
}
