import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

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

        Exception exception = assertThrows(ArithmeticException.class, () -> ComponentTestObject.setX(-100));
        assertEquals("Can not set negative positions", exception.getMessage());
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
         * @Throws RuntimeException
         */

        Exception exception = assertThrows(ArithmeticException.class, () -> ComponentTestObject.setY(-100));
        assertEquals("Can not set negative positions", exception.getMessage());
    }

    @Test
    void setWidth() {
    }

    @Test
    void setHeight() {
    }

    @Test
    void setImagePath() {
    }

    @Test
    void getX() {
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

