import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.swing.*;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


/**
 * This class is the controller class of game(After Refactoring)
 * Mainly Integration and Functional Test Are Conducted
 *
 *
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
    
    /**
     * Integration/Functional Test for  Create wall with Component Module
     * Testing the walls array is populated properly or not
     *
     */
    @Test
    void initializeGameComponentsTest() {
        gamePanelTestObject.initializeGameComponents();
        assertNotNull(gamePanelTestObject.walls);
    }

    /**
     * Integration/Functional Test for gravityPull with Component Module
     * Testing if the Game bird is feeling the gravity pull on each state change
     *
     */
    @Test
    void gravityPullTest() {
        gamePanelTestObject.bird.setY(10);
        int expected = 12;
        gamePanelTestObject.gravityPull();
        assertEquals(expected, gamePanelTestObject.bird.getY());
    }


    @Test
    void scrollWalls() {

    }

    /**
     * Test case for scrollBG using Graph Partitioning
     * Test case 01: For node with X greater than -700
     *
     */

    @Test
    void scrollBGWithXGreaterThanNegativeSevenHundredTest(){
        gamePanelTestObject.background1.setX(200);
        gamePanelTestObject.scrollBG();
        assertEquals(199,  gamePanelTestObject.background1.getX());
    }

    /**
     * Test case for scrollBG using Graph Partitioning
     * Test case 02: For node with X less than -700
     *
     */
    @Test
    void scrollBGWithXLessThanNegativeSevenHundredTest(){
        gamePanelTestObject.background1.setX(-701);
        gamePanelTestObject.scrollBG();
        assertEquals(700,  gamePanelTestObject.background1.getX());
    }

    @Test
    void scrollGround() {
    }

    @Test
    void flapTest() {
        gamePanelTestObject.bird.setY(10);
        int expected = 4;
        gamePanelTestObject.flap();
        assertEquals(expected, gamePanelTestObject.bird.getY());
    }

    @Disabled("Paint method NOT feasible for testing")
    @Test
    void paint() {
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

    /**
     * Test case for checking if 8 walls are created properly
     *
     */
    @Test
    void createWalls() {
        gamePanelTestObject.createWalls();
        assertNotNull(gamePanelTestObject.walls[1]);
    }
    
    /**
     * Parameterized test for isStarted And setStarted Method
     *
     */
    @ParameterizedTest
    @MethodSource("providePartitionedValueForIsStartedAndSetStartedCombinedTest")
    void isStartedAndSetStartedCombinedTest(boolean input, boolean expected) {
        gamePanelTestObject.setStarted(input);
        assertEquals(expected, gamePanelTestObject.isStarted());
    }

    /**
     * Test case using input space partition for isStarted And setStarted.
     * The input domain is divided into two parts, true and false
     *
     */
    private static Stream<Arguments> providePartitionedValueForIsStartedAndSetStartedCombinedTest() {
        return Stream.of(
            Arguments.of(true, true),
            Arguments.of(false, false)
        );
    }

    /**
     * Setting gameover to true and Testing the method
     *
     */
    @Test
    void isGameOverTestWithTrue() {

        gamePanelTestObject.setGameOver(true);
        assertTrue(gamePanelTestObject.isGameOver());
    }

    /**
     * Setting gameover to False and Testing the method
     *
     */
    @Test
    void isGameOverTestWithFalse() {
        gamePanelTestObject.setGameOver(false);
        assertFalse(gamePanelTestObject.isGameOver());
    }

    /**
     * Parameterized test for isGameOver
     *
     */
    @ParameterizedTest
    @MethodSource("providePartitionedValueForIsGameOverTest")
    void isGameOverTest(boolean input, boolean expected) {
        gamePanelTestObject.setGameOver(input);
        assertEquals(expected, gamePanelTestObject.isGameOver());

    }

    /**
     * isGameOver has only one implicit parameter,
     * It is either true or false
     * So there's test for these two states
     *
     */
    private static Stream<Arguments> providePartitionedValueForIsGameOverTest() {
        return Stream.of(
                Arguments.of(true, true),
                Arguments.of(false, false)
        );
    }
    
    /**
     * setGameOver has only one parameter,
     * takes the the state of gameover as boolean and saves it
     * It is either true or false
     * So there's test for these two states
     *
     */
    @Test
    void setGameOverTest() {
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



    @Disabled("keyReleased method NOT feasible for testing, it has no content")
    @Test
    void keyReleased() {
    }

    @Disabled("keyTyped method NOT feasible for testing, it has no content")
    @Test
    void keyTyped() {
    }
}
