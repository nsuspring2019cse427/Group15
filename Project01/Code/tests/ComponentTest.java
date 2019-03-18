import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test
    void setX() {

        /**
         * Test case using input space partition for X position.
         * The input domain is divided into three parts, 0, negative values and positive values
         * Only 0 and positive value is accepted, since screen does not have negative positions
         *
         */

        /**
         * Test of positive input space partition for X position
         * should pass
         */
        ComponentTestObject.setX(200);
        assertEquals(200, ComponentTestObject.getX());


        /**
         * Test case of 0 for X position
         * should pass
         */
        ComponentTestObject.setX(0);
        assertEquals(0, ComponentTestObject.getX());

        /**
         * Test case of negative input space partition for X position
         * should pass
         * @Throws RuntimeException
         */

        ComponentTestObject.setX(-111);
        assertEquals(-111, ComponentTestObject.getX());
    }

    @Test
    void setY() {
        /**
         * Test case using input space partition for Y position.
         * The input domain is divided into three parts, 0, negative values and positive values
         * Only 0 and positive value is accepted, since screen does not have negative positions
         *
         */

        /**
         * Test of positive input space partition for Y position
         * should pass
         */
        ComponentTestObject.setY(200);
        assertEquals(200, ComponentTestObject.getY());


        /**
         * Test case of 0 for Y position
         * should pass
         */
        ComponentTestObject.setY(0);
        assertEquals(0, ComponentTestObject.getY());

        /**
         * Test case of negative input space partition for Y position
         * should pass
         *
         */
        ComponentTestObject.setY(-110);
        assertEquals(-110, ComponentTestObject.getY());


    }

    @Test
    void setWidth() {
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
    void setHeight() {
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
    void setImagePath() {

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
    void getX() {
        //TODO partition in three parts, valid, and null,
    }

    @Test
    void getY() {
    }

    @Test
    void getWidth() {
    }

    @Test
    void getHeight() {
    }

    @Test
    void getImagePath() {
    }
}

