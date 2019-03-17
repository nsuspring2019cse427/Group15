import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameSoundTest {

    /**
     * INITIALIZATION
     *
     **/
    private GameSound testObject;
    private GameSound testObjectWithWrongAudioFile;


    @Before
    public void setUp() throws Exception {
        /**
         * Partitioning the input domain into two parts
         *
         * 01 Valid audio input file
         * 02 Invalid audio input file line
         *
         **/
        testObject = new GameSound("sounds//flap.wav");
        testObjectWithWrongAudioFile = new GameSound("InvalidLink");
    }

    @After
    public void tearDown() throws Exception {
        /**
         * Discarding Objects
         *
         **/
        testObject = null;
        testObjectWithWrongAudioFile = null;
    }

    @Test
    public void audioFeedbackTest() {
        /**
         * Assert for valid input audio file
         *
         **/
        assertTrue(testObject.playAudioFeedback());

        /**
         * Assert for Invalid input audio file
         *
         **/
        assertFalse(testObjectWithWrongAudioFile.playAudioFeedback());
    }
}
