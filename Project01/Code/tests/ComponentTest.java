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
    void draw() {
    }

    @Test
    void setX() {
        /**
         * Test case using input space partition.
         * The input domain is divided into three parts, 0, negative values and positive values
         * Only 0 and positive value is accepted, since screen does not have negative positions
         *
         */

        /**
         * Test for positive input space
         */
        ComponentTestObject.setX(200);
        assertEquals(200, ComponentTestObject.getX());


        /**
         * Test case for 0
         */
        ComponentTestObject.setX(0);
        assertEquals(0, ComponentTestObject.getX());

        /**
         * Test case for negative numbers
         * @Throws RuntimeException
         */

        Exception exception = assertThrows(ArithmeticException.class, () -> ComponentTestObject.setX(-100));
        assertEquals("Can not set negative positions", exception.getMessage());
    }

    @Test
    void setY() {
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

