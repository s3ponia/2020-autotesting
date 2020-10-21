import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class ListTest {

    private static List<Integer> source;
    private static final Random rand = new Random();

    @BeforeAll
    static void init() {
        source = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            source.add(i);
        }
    }

    @DisplayName("Check source size")
    @Test
    void countTest() {
        assertEquals(source.size(), 100);
    }

    @DisplayName("Random test")
    @Test
    void randomTest() {
        boolean test = false;
        for (int i = 0; i < 100; i++) {
            int r = rand.nextInt();
            if (r > source.size()) {
                test = true;
            }
        }

        assertTrue(test);
    }

    @DisplayName("Always failed")
    @RepeatedTest(100)
    void checkTest() {
        assertAll(() -> assertTrue(false),
                () -> assertTrue(source.get(0).equals(0)),
                () -> assertEquals(source.get(source.size() - 1) - source.get(0), source.size()));
    }

    @AfterAll
    static void done() {
        source.clear();
    }
}
