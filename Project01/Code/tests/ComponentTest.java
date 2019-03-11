import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.awt.*;


public class ComponentTest {
    private Component ComponentTestObject;

    @Before
    public void setUp() throws Exception {
        ComponentTestObject = new Component(0, 0, 700, 490, "images//background.png");
    }

    @After
    public void tearDown() throws Exception {
        ComponentTestObject = null;
    }

    @Test
    public void draw() {

    }

    @Test
    public void setX() {
        ComponentTestObject.setX(200);
        assertEquals(200, ComponentTestObject.getX());
    }

    @Test
    public void setY() {

    }

    @Test
    public void setWidth() {
    }

    @Test
    public void setHeight() {
    }

    @Test
    public void setImagePath() {
    }

    @Test
    public void getX() {
        assertEquals(200, ComponentTestObject.getX());
    }

    @Test
    public void getY() {
    }

    @Test
    public void getWidth() {
    }

    @Test
    public void getHeight() {
    }

    @Test
    public void getImagePath() {
    }
}