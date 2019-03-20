import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;



/**
 * This class is not fully testable
 * Probably in integration we will be able to test it,
 * Since this class integrates all the modules in it.
 *
 * Possible test cases are added though
 */




class GamePanelTest extends JPanel {

    private GamePanel gamePanelTestObject;

    @BeforeEach
    void setUp() {
        gamePanelTestObject = new GamePanel();
    }

    @AfterEach
    void tearDown() {
        gamePanelTestObject = null;
    }

    @Test
    void start() {

        /**
         * Test to check game can start by calling Start method.
         * if it has started the return value will be always true
         *
         */
        assertTrue(gamePanelTestObject.Start());
    }

    @Disabled("gravityPull method NOT feasible for testing")
    @Test
    void gravityPullTest() {

    }

    @Disabled("scrollWalls method NOT feasible for testing")
    @Test
    void scrollWalls() {
    }

    @Disabled("scrollBG method NOT feasible for testing")
    @Test
    void scrollBG() {
    }

    @Disabled("scrollGround method NOT feasible for testing")
    @Test
    void scrollGround() {
    }


    @Disabled("Paint method NOT feasible for testing")
    @Test
    void paint() {
    }

    @Test
    void checkCollision() {
    }

    @Test
    void keyPressed() {
    }

    /**
     * Parameterized test for IncrementScore Method
     */
    @ParameterizedTest
    @MethodSource("providePartitionedValueForIncrementScoreTest")
    void incrementScore(double input, double expected) {
        assertEquals(expected, gamePanelTestObject.incrementScore(0, input), 1);

    }

    /**
     * Test case using input space partition for IncreamentScore.
     * The input domain is divided into three parts, 0, negative values and positive values
     * all types of double value from negative to positive is supported
     *
     */
    private static Stream<Arguments> providePartitionedValueForIncrementScoreTest() {
        return Stream.of(
                Arguments.of(200.0, 200.0),
                Arguments.of(0.0, 0.0),
                Arguments.of(-1220.0, -1220.0)
        );
    }

    @Test
    void createWalls() {

    }

    @Test
    void isStarted() {

    }

    @Test
    void setStarted() {
    }

    /**
     * isGameOver has only one implicit parameter,
     * It is either true or false
     * So there's test for these two states
     *
     */

    @Test
    void isGameOverTest() {
        /**
         * Setting gameover to true and Testing the method
         *
         */
        gamePanelTestObject.setGameOver(true);
        assertTrue(gamePanelTestObject.isGameOver());

        /**
         * Setting gameover to False and Testing the method
         *
         */
        gamePanelTestObject.setGameOver(false);
        assertFalse(gamePanelTestObject.isGameOver());
    }


    /**
     * setGameOver has only one parameter,
     * takes the the state of gameover as boolean and saves it
     * It is either true or false
     * So there's test for these two states
     *
     */
    @Test
    void setGameOver() {
        /**
         * Setting gameover to true and Testing the method
         *
         */
        gamePanelTestObject.setGameOver(true);
        assertTrue(gamePanelTestObject.isGameOver());

        /**
         * Setting gameover to False and Testing the method
         *
         */
        gamePanelTestObject.setGameOver(false);
        assertFalse(gamePanelTestObject.isGameOver());
    }

    @Test
    void keyReleased() {
    }

    @Test
    void keyTyped() {
    }
}