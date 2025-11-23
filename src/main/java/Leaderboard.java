import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manages a persistent leaderboard of player scores.
 * <p>
 * The {@code Leaderboard} class is responsible for storing, sorting,
 * saving and loading a list of {@link LeaderboardEntry} objects.
 * Entries are saved to a text file, allowing scores to persist across program runs.
 * </p>
 *
 * <h2>File Format</h2>
 * Each line in the leaderboard file is stored as:
 * <pre>
 *     name,score
 * </pre>
 *
 * <p>
 * The class supports two constructors: one for normal gameplay using the default
 * {@code leaderboard.txt} file, and another for testing, allowing injection of
 * a temporary file to avoid interfering with real saved scores.
 * </p>
 */
public class Leaderboard {

    /** The list of leaderboard entries loaded from or saved to file. */
    private ArrayList<LeaderboardEntry> entries;

    /** The file used to store persistent leaderboard data. */
    private File file;

    /**
     * Constructs a new {@code Leaderboard} using the default
     * {@code leaderboard.txt} file in the working directory.
     * <p>
     * Upon construction, the file (if present) is read and parsed to populate
     * the entries list.
     * </p>
     */
    public Leaderboard() {
        entries = new ArrayList<>();
        file = new File("leaderboard.txt");
        loadFromFile();
    }

    /**
     * Constructs a {@code Leaderboard} using a custom file.
     * <p>
     * This constructor is primarily intended for unit testing, where using a
     * separate temporary file prevents modification of the real leaderboard.
     * </p>
     *
     * @param file the file to load from and save to
     */
    public Leaderboard(File file) {
        entries = new ArrayList<>();
        this.file = file;
        loadFromFile();
    }

    /**
     * Adds a new entry to the leaderboard, sorts all entries in descending
     * score order, and saves the updated leaderboard to disk.
     *
     * @param name  the player's name
     * @param score the player's final score
     */
    public void addEntry(String name, int score) {
        entries.add(new LeaderboardEntry(name, score));
        sortEntries();
        saveToFile();
    }

    /**
     * Returns the list of leaderboard entries.
     * <p>
     * The returned list is the internal list; modifications will affect the
     * leaderboard. This is acceptable for this project, but an immutable list
     * could be returned in a more restrictive design.
     * </p>
     *
     * @return the list of leaderboard entries
     */
    public ArrayList<LeaderboardEntry> getEntries() {
        return entries;
    }

    /**
     * Sorts the leaderboard entries in descending order by score.
     * <p>
     * This method ensures that higher scores always appear at the top of the
     * leaderboard. It is private because sorting should only occur internally
     * when updating the stored data.
     * </p>
     */
    private void sortEntries() {
        entries.sort((a, b) -> Integer.compare(b.getScore(), a.getScore()));
    }

    /**
     * Saves all leaderboard entries to the associated file.
     * <p>
     * Each entry is written on its own line in the format {@code name,score}.
     * Errors are caught and logged to the console, but not rethrown, as failure
     * to save the leaderboard is not considered fatal for gameplay.
     * </p>
     */
    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(file)) {
            for (LeaderboardEntry entry : entries) {
                writer.println(entry.getName() + "," + entry.getScore());
            }
        } catch (Exception e) {
            System.out.println("Error writing leaderboard file.");
        }
    }

    /**
     * Loads leaderboard entries from the associated file, if it exists.
     * <p>
     * Each line is parsed into a {@link LeaderboardEntry}. Invalid lines or
     * formatting errors are caught and logged, but do not stop execution.
     * </p>
     */
    private void loadFromFile() {
        if (!file.exists()) return;

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(",");
                String name = parts[0];
                int score = Integer.parseInt(parts[1]);
                entries.add(new LeaderboardEntry(name, score));
            }
        } catch (Exception e) {
            System.out.println("Error reading leaderboard file.");
        }
    }

    /**
     * Prints the leaderboard to the console in a user-friendly format.
     * <p>
     * If no scores are present, a message indicating this is shown instead.
     * </p>
     */
    public void printLeaderboard() {
        System.out.println("\n--- Leaderboard ---");
        if (entries.isEmpty()) {
            System.out.println("No scores yet!");
            return;
        }
        for (LeaderboardEntry e : entries) {
            System.out.println(e);
        }
    }
}
