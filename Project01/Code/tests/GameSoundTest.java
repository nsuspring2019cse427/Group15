import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collection;

/**
 * Tests are based on Junit 4
 *
 *
 */


@RunWith(Parameterized.class)
public class GameSoundTest {

    /**
     * INITIALIZATION OF VARIABLES
     *
     **/
    private GameSound testObject;
    private String inputFile;
    private boolean expected;

    /**
     * Creating a new object each time a test is run
     * from the input space partition
     *
     */
    @Before
    public void setUp() throws Exception {
        testObject = new GameSound(inputFile);
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
     * Constructor of each test with different values
     *
     **/
    public GameSoundTest(String inputFile, Boolean expected) {
        this.inputFile = inputFile;
        this.expected = expected;
    }


    /**
     * Partitioning the input domain into two parts null and Valid String
     *
     * Graph Partition:
     * 01 Valid audio input file and Invalid audio input file line in GameSoundTestForException
     *
     **/
    @Parameterized.Parameters
    public static Collection SoundFiles() {
        return Arrays.asList(new Object[][] {
                { "sounds//point.wav", true },
                { "dsfsdfsdfsd", false }
        });
    }

    /**
     * Test for every input audio file
     *
     **/
    @Test
    public void playAudioFeedbackTest() {
        assertEquals(expected, testObject.playAudioFeedback());
    }

}




