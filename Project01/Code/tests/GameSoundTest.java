import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameSoundTest {
    private GameSound testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new GameSound("sounds//flap.wav");
    }

    @After
    public void tearDown() throws Exception {
        testObject = null;
    }

    @Test
    public void audioFeedbackTest() {
        assertTrue(testObject.playAudioFeedback());
    }
}