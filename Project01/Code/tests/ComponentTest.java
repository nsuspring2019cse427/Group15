import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.awt.*;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ComponentTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void draw(Graphics g) {
        Component ground1 = new Component(0, 445, 750, 490, "images//ground.png");
        assertTrue(ground1.draw(g));
    }

    @Test
    public void setX() {
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