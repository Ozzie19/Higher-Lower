import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

public class LeaderboardTest {

    private final File tempFile = new File("test_leaderboard.txt");

    @AfterEach
    void cleanUp() throws Exception {
        if (tempFile.exists()) {
            Files.delete(tempFile.toPath());
        }
    }

    @Test
    void testAddEntryStoresCorrectly() {
        Leaderboard lb = new Leaderboard(tempFile);

        lb.addEntry("Alice", 10);
        lb.addEntry("Bob", 20);

        assertEquals(2, lb.getEntries().size());
        assertEquals("Bob", lb.getEntries().get(0).getName());
        assertEquals(20, lb.getEntries().get(0).getScore());  // highest score first
    }

    @Test
    void testEntriesPersistAfterReloading() {
        Leaderboard lb = new Leaderboard(tempFile);
        lb.addEntry("Charlie", 15);

        // Reload from file
        Leaderboard loaded = new Leaderboard(tempFile);

        assertEquals(1, loaded.getEntries().size());
        assertEquals("Charlie", loaded.getEntries().get(0).getName());
        assertEquals(15, loaded.getEntries().get(0).getScore());
    }

    @Test
    void testSortingDescending() {
        Leaderboard lb = new Leaderboard(tempFile);
        lb.addEntry("A", 5);
        lb.addEntry("B", 50);
        lb.addEntry("C", 20);

        assertEquals("B", lb.getEntries().get(0).getName());
        assertEquals("C", lb.getEntries().get(1).getName());
        assertEquals("A", lb.getEntries().get(2).getName());
    }
}
