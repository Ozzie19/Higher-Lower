import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Leaderboard {

    private ArrayList<LeaderboardEntry> entries;
    private File file;

    // DEFAULT constructor
    public Leaderboard() {
        entries = new ArrayList<>();
        file = new File("leaderboard.txt");
        loadFromFile();
    }

    // for testing purposes
    public Leaderboard(File file) {
        entries = new ArrayList<>();
        this.file = file;
        loadFromFile();
    }


    public void addEntry(String name, int score) {
        entries.add(new LeaderboardEntry(name, score));
        sortEntries();
        saveToFile();
    }

    public ArrayList<LeaderboardEntry> getEntries() {
        return entries;
    }

    private void sortEntries() {
        entries.sort((a, b) -> Integer.compare(b.getScore(), a.getScore()));
    }

    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(file)) {
            for (LeaderboardEntry entry : entries) {
                writer.println(entry.getName() + "," + entry.getScore());
            }
        } catch (Exception e) {
            System.out.println("Error writing leaderboard file.");
        }
    }

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
