import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameSoundTestForException {

    /**
     * INITIALIZATION OF VARIABLES
     *
     **/
    private GameSound testObject;

    /**
     * Creating a new object each time a test is run
     * from the input space partition
     *
     */
    @Before
    public void setUp() throws Exception {
        testObject = new GameSound("Invalid-file");
    }

    /**
     * Discarding Objects after each call
     *
     **/
    @After
    public void tearDown() throws Exception {
        testObject = null;
    }


    /**
     * Graph Partition:
     * 02 Invalid audio input file line
     *
     **/
    @Test
    public void playAudioFeedbackTestWithException() {
        Exception exception = assertThrows(RuntimeException.class, () -> testObject.playAudioFeedback());
        assertEquals("Sound file loading error!", exception.getMessage());
    }

}
