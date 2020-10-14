import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EasyTest {

    private static List<String> source;

    @BeforeAll
    static void setUp() {
        source = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            source.add(RandomStringUtils.random(10, true, false));
        }
    }

    @DisplayName("Count test successful")
    @Test
    void countTest() {
        assertEquals(source.size(), 10);
    }

    @DisplayName("Mostly failed test")
    @Test
    void checkTest() {
        assertAll("source",
                () -> assertTrue(source.get(0).startsWith("A")),
                () -> assertEquals(source.get(0), source.get(source.size() - 1)));
    }

    @AfterAll
    static void done() {
        source.clear();
    }
}
