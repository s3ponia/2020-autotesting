package tests;

import classes.Cat;
import classes.Dog;
import classes.Math;
import classes.Node;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;


public class DogCatTest {

    private static final Logger logger = Logger.getLogger("DogCatTest");


    static int a;
    static int b;

    Node root;
    Node left;

    @BeforeEach
    void eachInit() {
        logger.info("Test case was started!");
        left = new Node("3", null, null);
        root = new Node("5", left, null);
    }

    @BeforeAll
    static void init() {
        logger.info("Test cases were started!");
        a = 5;
        b = 7;
    }

    @RepeatedTest(value = 30)
    void test1() {
        Assertions.assertEquals(left, root.left);
        assertNotNull(root.left);
        assertNull(root.right);
        assertThrows(NullPointerException.class, () -> root.right.left = null);
    }

    @Test
    @DisplayName("Successful test!")
    void test2() {

    }

    @Test
    @Tag(value = "tag1")
    void testCorrectFields() {
        Cat cat = new Cat("john", 2, true, true, "Whiskas");
        assertAll("cat",
                () -> Assertions.assertEquals("john", cat.name),
                () -> Assertions.assertEquals(2, cat.age),
                () -> Assertions.assertTrue(cat.isSleepy),
                () -> Assertions.assertTrue(cat.sex),
                () -> Assertions.assertEquals("Whiskas", cat.favoriteFood)
        );
    }

    @Test
    @Tag(value = "tag1")
    void testIterableCats() {
        List<Dog> dogs = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        assertIterableEquals(dogs, cats);

        Cat cat = new Cat("john", 2, true, true, "Whiskas");
        cats.add(cat);

        Cat[] cats1 = new Cat[1];
        cats1[0] = cat;
        assertIterableEquals(Arrays.asList(cats1), cats);
    }

    @ParameterizedTest
    @ValueSource(strings = { "Emilia", "Tom", "Ilyxa" })
    void parameterizedNames(String argument) {
        Cat cat = new Cat(argument, 2, true, true, "Whiskas");

        Assertions.assertEquals(argument, cat.name);
    }

    @Test
    void streamTest() {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("john", 2, true, true, "Whiskas"));
        cats.add(new Cat("tom", 5, true, true, "Whiskas"));
        cats.add(new Cat("vlad", 1, true, true, "Whiskas"));

        assertTrue(cats.stream()
                .mapToInt(cat -> cat.age)
                .sum()> 7, "Should be greater than 5"
        );
    }



    @Nested
    class InnerTest {

        @Test
        void mathTest() {
            Assertions.assertEquals(12, Math.sum(a, b));

            Assertions.assertEquals(left, root.left);
        }

    }

    @AfterEach
    void tearDown() {
        logger.info("Test case was completed!");
    }
    @AfterAll
    static void done() {
        logger.info("All test cases were completed!");
    }

}
