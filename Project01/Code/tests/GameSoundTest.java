import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameSoundTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void flapSound() {
        assertTrue(GameSound.audioFeedback("sounds//flap.wav"));
    }

    @Test
    public void hitSound() {
    }

    @Test
    public void pointSound() {
    }
}