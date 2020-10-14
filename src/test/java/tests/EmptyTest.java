package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(value = TestInstance.Lifecycle.PER_METHOD)
public class EmptyTest {

    @Test
    @Tag("tag1")
    @Disabled
    void empty() {
        String str = "nothing";
        assertTrue("nothing".equals(str));
    }

    @Test
    @DisabledOnOs(value = OS.WINDOWS)
    void disabledOS() {
        assertEquals(1, 0 + 1);
    }

}
