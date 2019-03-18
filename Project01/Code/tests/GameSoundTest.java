import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

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
     * INITIALIZATION
     *
     **/
    private GameSound testObject;
    private String inputFile;
    private boolean expected;


    @Before
    public void setUp() throws Exception {
        /**
         * Creating a new object each time a test is run
         * from the input space partition
         *
         */
        testObject = new GameSound(inputFile);
    }

    @After
    public void tearDown() throws Exception {
        /**
         * Discarding Objects after each call
         *
         **/
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

    @Parameterized.Parameters
    public static Collection primeNumbers() {

        /**
         * Partitioning the input domain into two parts
         *
         * 01 Valid audio input file
         * 02 Invalid audio input file line
         *
         **/
        return Arrays.asList(new Object[][] {
                { "sounds//die.wav", true },
                { "sounds//point.wav", true },
                { "dsfsdfsdfsd", false },
                { "sounds//flap.wav", true },
                { "Invalid-file", false }
        });
    }

    @Test
    public void playAudioFeedbackTest() {

        /**
         * Test for every input audio file
         *
         **/
        assertEquals(expected, testObject.playAudioFeedback());
    }

}
