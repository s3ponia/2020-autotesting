import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assumptions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

public class IntegerListTest {

    final Random rand = new Random();
    private List<Integer> source;

    @BeforeEach
    void init() {
        source = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            source.add(rand.nextInt() & Integer.MAX_VALUE);
        }
    }

    @Test
    void assumptionTest() {
        assumeTrue(source.get(10) >= 0);
        assertTrue((source.get(0) + source.get(source.size() - 1)) / source.get(10) < 251);
    }

    @RepeatedTest(100)
    void repeatTest() {
        assertTrue(source.stream().filter(a -> a > 0).count() > 0);
    }

    @AfterEach
    void done() {
        source.clear();
    }
}
