import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.condition.DisabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assumptions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.junit.jupiter.api.condition.JRE.JAVA_11;
import static org.junit.jupiter.api.condition.JRE.JAVA_8;

import java.util.Random;

public class IntegerListTest {

    final Random rand = new Random();
    private List<Integer> source;

    @BeforeEach
    void init() {
        source = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            source.add(rand.nextInt());
        }
    }

    @Test
    void assumptionTest() {
        assumeTrue(source.get(0) > 0);
        assumeFalse(source.get(10) < 125);
        assertFalse((source.get(0) + source.get(source.size() - 1)) / 2 - 10 < 251);
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
