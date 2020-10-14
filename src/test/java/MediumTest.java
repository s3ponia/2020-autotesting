import org.apache.commons.lang3.RandomStringUtils;
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

public class MediumTest {

    private List<Integer> source;

    @BeforeEach
    void init() {
        source = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            source.add(Integer.parseInt(RandomStringUtils.random(2, false, true)));
        }
    }

    @Test
    void assumptionTest() {
        assumeTrue(source.get(0) > 50);
        assumeFalse(source.get(1) < 50);
        assertFalse(source.get(0) + source.get(1) > 100);
    }

    @RepeatedTest(10)
    @EnabledOnJre(JAVA_11)
    void repeatNewTest() {
        assertTrue(source.stream().mapToInt(i->i).sum() > 500);
    }

    @RepeatedTest(10)
    @DisabledForJreRange(min = JAVA_8, max = JAVA_11)
    void repeatOldTest() {
        int sum = 0;
        for (Integer integer : source) {
            sum += integer;
        }
        assertFalse(sum < 500);
    }

    @ParameterizedTest
    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
    void whitespaceTest(final String candidate) {
        assertTrue(StringUtils.doesNotContainWhitespace(candidate));
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStream() {
        return Stream.of("racecar", "radar", "mom", "dad")
                .map(text -> dynamicTest(text, () -> assertEquals(text, new StringBuilder(text).reverse().toString())));
    }

    @AfterEach
    void done() {
        source.clear();
    }
}
