import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests are based on Junit 5
 *
 *
 */

class ComponentTest {
    private Component ComponentTestObject;

    @BeforeEach
    void setUp() {
        ComponentTestObject = new Component(0, 0, 700, 490, "images//background.png");
    }

    @AfterEach
    void tearDown() {
        ComponentTestObject = null;
    }


    @ParameterizedTest
    @MethodSource("providePartitionedValueForSetXTest")
    void setXTest(int input, int expected) {

        /**
         * Setting x then checking if it was success or not using assert
         */
        ComponentTestObject.setX(input);
        assertEquals(expected, ComponentTestObject.getX());
    }

    /**
     * Test case using input space partition for X position.
     * The input domain is divided into three parts, 0, negative values and positive values
     * all types of int value from negative to positive is supported
     *
     */

    private static Stream<Arguments> providePartitionedValueForSetXTest() {
        return Stream.of(
                Arguments.of(200, 200),
                Arguments.of(200, 200),
                Arguments.of(0, 0),
                Arguments.of(-110, -110),
                Arguments.of(-1220, -1220)
        );
    }

    @ParameterizedTest
    @MethodSource("providePartitionedValueForSetYTest")
    void setYTest(int input, int expected) {

        /**
         * Setting Y then checking if it was success or not using assert
         */
        ComponentTestObject.setY(input);
        assertEquals(expected, ComponentTestObject.getY());
    }

    /**
     * Test case using input space partition for Y position.
     * The input domain is divided into three parts, 0, negative values and positive values
     * all types of int value from negative to positive is supported
     *
     */

    private static Stream<Arguments> providePartitionedValueForSetYTest() {
        return Stream.of(
                Arguments.of(200, 200),
                Arguments.of(200, 200),
                Arguments.of(0, 0),
                Arguments.of(-110, -110),
                Arguments.of(-1220, -1220)
        );
    }



    @Test
    void setWidthTest() {
        /**
         * Test case using input space partition for Component Width.
         * The input domain is divided into three parts, 0, negative values and positive values
         * Only 0 and positive value is accepted, since widths cannot be negative.
         *
         */

        /**
         * Test of positive input space partition for Width
         * should pass
         */
        ComponentTestObject.setWidth(200);
        assertEquals(200, ComponentTestObject.getWidth());


        /**
         * Test case of 0 for Width
         * should pass
         */
        ComponentTestObject.setWidth(0);
        assertEquals(0, ComponentTestObject.getWidth());

        /**
         * Test case of negative input space partition for Width
         * should pass with exception
         * @Throws RuntimeException as the value is not acceptable.
         */
        Exception exception = assertThrows(RuntimeException.class, () -> ComponentTestObject.setWidth(-100));
        assertEquals("Cannot set negative width", exception.getMessage());
    }

    @Test
    void setHeightTest() {
        /**
         * Test case using input space partition for Component Height.
         * The input domain is divided into three parts, 0, negative values and positive values
         * Only 0 and positive value is accepted, since Heights cannot be negative.
         *
         */

        /**
         * Test of positive input space partition for height
         * should pass
         */
        ComponentTestObject.setHeight(200);
        assertEquals(200, ComponentTestObject.getHeight());


        /**
         * Test case of 0 for Height
         * should pass
         */
        ComponentTestObject.setHeight(0);
        assertEquals(0, ComponentTestObject.getHeight());

        /**
         * Test case of negative input space partition for height
         * should pass with exception
         * @Throws RuntimeException as the value is not acceptable.
         */
        Exception exception = assertThrows(RuntimeException.class, () -> ComponentTestObject.setHeight(-100));
        assertEquals("Cannot set negative height", exception.getMessage());

    }

    @Test
    void setImagePathTest() {

        /**
         * Test case with valid file path
         * should pass with no exception
         *
         */
        ComponentTestObject.setImagePath("images//background.png");
        assertEquals("images//background.png", ComponentTestObject.getImagePath());

        /**
         * Test case with invalid file path
         * should pass with exception
         * @Throws RuntimeException as the path is not valid.
         */
        Exception exception = assertThrows(RuntimeException.class, () -> ComponentTestObject.setImagePath("invalidFilePath"));
        assertEquals("Invalid file", exception.getMessage());
    }

    @Test
    void getXTest() {

        /**
         * Test case to check if getX returns right value of X
         *
         */
        ComponentTestObject.setX(100);
        assertEquals(100, ComponentTestObject.getX());
    }

    @Test
    void getYTest() {

        /**
         * Test case to check if getY returns right value of Y
         *
         */
        ComponentTestObject.setY(200);
        assertEquals(200, ComponentTestObject.getY());
    }

    @Test
    void getWidthTest() {

        /**
         * Test case to check if getWidth returns right value of Width
         * should pass
         */
        ComponentTestObject.setWidth(200);
        assertEquals(200, ComponentTestObject.getWidth());
    }

    @Test
    void getHeightTest() {

        /**
         * Test case to check if getHeight returns right value of Height
         *
         */
        ComponentTestObject.setHeight(200);
        assertEquals(200, ComponentTestObject.getHeight());
    }

    @Test
    void getImagePathTest() {

        /**
         * Test case with valid file path to check if the getImagePath returns right path
         * should pass with no exception
         *
         */
        ComponentTestObject.setImagePath("images//wallUp.png");
        assertEquals("images//wallUp.png", ComponentTestObject.getImagePath());
    }
}

