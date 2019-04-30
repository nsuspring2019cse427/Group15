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

    /**
     * Test case using Graph Partitioning for detect collision
     * Two test cases needed to cover all the node.(One condition in the function)
     *
     * Test case 01: When detects collision
     *
     */

    @Test
    void detectCollisionWhenCollideTest() {
        Component newTestSubject = new Component(0, 0, 700, 490, "images//background.png");
        assertTrue(ComponentTestObject.detectCollision(newTestSubject));
    }

    /**
     * Test case 02: When The object dont collide
     *
     */
    @Test
    void detectCollisionWhenNotCollideTest() {
        Component newTestSubject = new Component(701, 491, 700, 490, "images//background.png");
        assertFalse(ComponentTestObject.detectCollision(newTestSubject));
    }

    /**
     * Test case using input space partition for X position.
     * The values are fed dynamically one by one from the providePartitionedValueForSetXTest
     *
     */
    @ParameterizedTest
    @MethodSource("providePartitionedValueForSetXTest")
    void setXTest(int input, int expected) {

        /**
         * Setting x, then checking if it was success or not using assert
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
                Arguments.of(0, 0),
                Arguments.of(-110, -110)
        );
    }
    
    /**
     * Test case using input space partition for Y position.
     * The values are fed dynamically one by one from the providePartitionedValueForSetYTest
     *
     */
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
                Arguments.of(0, 0),
                Arguments.of(-220, -220)
        );
    }


    /**
     * Test case using Graph Partitioning for Component Width.
     * The input domain is divided into three parts, 0, negative values and positive values
     * Only 0 and positive value is accepted, since widths cannot be negative.
     *
     */

    /**
     * Test of positive Graph Partition  for Width
     * should pass
     */
    @Test
    void setWidthTestWithGreaterThanZeroParameter() {
        ComponentTestObject.setWidth(200);
        assertEquals(200, ComponentTestObject.getWidth());
    }

    /**
     * Test case of 0 for Graph Partitioned Width
     * should pass
     */
    @Test
    void setWidthTestWithZeroParameter() {
        ComponentTestObject.setWidth(0);
        assertEquals(0, ComponentTestObject.getWidth());
    }

    /**
     * Test case of negative Graph Partition  for Width
     * should pass with exception
     * @Throws RuntimeException as the value is not acceptable.
     */
    @Test
    void setWidthTestWithNegativeParameterAndException() {
        Exception exception = assertThrows(RuntimeException.class, () -> ComponentTestObject.setWidth(-100));
        assertEquals("Cannot set negative width", exception.getMessage());
    }


    /**
     * Test case using Graph partition for Component Height.
     * The value of Height is divided into three parts, 0, negative values and positive values
     * Only 0 and positive value is accepted, since Heights cannot be negative.
     *
     */

    /**
     * Test of positive input space partition for height
     * should pass
     */
    @Test
    void setHeightTestWithZeroParameter() {

        ComponentTestObject.setHeight(200);
        assertEquals(200, ComponentTestObject.getHeight());
    }


    /**
     * Test case of 0 for Height Using Graph Partition
     * should pass
     */
    @Test
    void setHeightTestGreaterThanZeroParameter() {

        ComponentTestObject.setHeight(0);
        assertEquals(0, ComponentTestObject.getHeight());
    }


    /**
     * Test case of negative Graph Partition for height
     * should pass with exception
     * @Throws RuntimeException as the value is not acceptable.
     */

    @Test
    void setHeightTestWithNegativeParameterAndException() {
        Exception exception = assertThrows(RuntimeException.class, () -> ComponentTestObject.setHeight(-100));
        assertEquals("Cannot set negative height", exception.getMessage());
    }


    /**
     * Test case with valid file path Using Graph Partition if case
     * should pass with no exception
     *
     */
    @Test
    void setImagePathTestWithValidPath() {
        ComponentTestObject.setImagePath("images//background.png");
        assertEquals("images//background.png", ComponentTestObject.getImagePath());
    }

    /**
     * Test case with invalid file path Using Graph Partition else case
     * should pass with exception
     * @Throws RuntimeException as the path is not valid.
     */
    @Test
    void setImagePathTestWithInvalidPathAndException() {
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

