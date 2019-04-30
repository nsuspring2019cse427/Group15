import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


/**
 * This class is the controller class of game(After Refactoring)
 * Mainly Integration and Functional Test Are Conducted
 *
 *
 */


class GamePanelTest {

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
     * Covers input space partition
     *
     */
    @Test
    void gravityPullWithPositiveStateVariableTest() {
        gamePanelTestObject.bird.setY(10);
        int expected = 12;
        gamePanelTestObject.gravityPull();
        assertEquals(expected, gamePanelTestObject.bird.getY());
    }

    @Test
    void gravityPullWithZeroStateVariableTest() {
        gamePanelTestObject.bird.setY(0);
        int expected = 2;
        gamePanelTestObject.gravityPull();
        assertEquals(expected, gamePanelTestObject.bird.getY());
    }

    @Test
    void gravityPullWithNegativeStateVariableTest() {
        gamePanelTestObject.bird.setY(-10);
        int expected = -8;
        gamePanelTestObject.gravityPull();
        assertEquals(expected, gamePanelTestObject.bird.getY());
    }

    /**
     * Test case for scrollWalls using Graph Partitioning
     *
     * Test case 01: covers path (1, 2, 3, 4, 6, 7, 8)
     *
     *  Covers all Node and Edges
     *
     */

    @Test
    void scrollWallsForPathOneTest() {
        gamePanelTestObject.createWalls();
        int expected = gamePanelTestObject.walls[1].getX() - 2;
        gamePanelTestObject.scrollWalls();
        assertEquals(expected, gamePanelTestObject.walls[1].getX());
    }

    /**
     * Test case 02: covers path (1, 2, 3, 5, 6, 7, 8)
     *
     */
    @Test
    void scrollWallsForPathTwoTest() {
        gamePanelTestObject.createWalls();
        gamePanelTestObject.walls[1].setX(-152);
        int expected = gamePanelTestObject.walls[1].getX() - 2;
        gamePanelTestObject.scrollWalls();
        assertEquals(expected, gamePanelTestObject.walls[1].getX());
    }


    /**
     * Test case for scrollBG using Graph Partitioning
     * Covers:  Node Coverage, Edge Coverage
     *
     * Test case 01: For path 1
     */

    @Test
    void scrollBGOneWithXGreaterThanNegativeSevenHundredTest(){
        gamePanelTestObject.background1.setX(200);
        gamePanelTestObject.scrollBG();
        assertEquals(199,  gamePanelTestObject.background1.getX());
    }

    /**
     * Test case for scrollBG using Graph Partitioning
     * Test case 02: For path 2
     *
     */
    @Test
    void scrollBGOneWithXLessThanNegativeSevenHundredTest(){
        gamePanelTestObject.background1.setX(-701);
        gamePanelTestObject.scrollBG();
        assertEquals(700,  gamePanelTestObject.background1.getX());
    }

    /**
     * Test case for scrollBG using Graph Partitioning
     * Test case 03: For path 3
     *
     */
    @Test
    void scrollBGTwoWithXGreaterThanNegativeSevenHundredTest(){
        gamePanelTestObject.background2.setX(200);
        gamePanelTestObject.scrollBG();
        assertEquals(199,  gamePanelTestObject.background2.getX());
    }

    /**
     * Test case for scrollBG using Graph Partitioning
     * Test case 04: For path 4
     *
     */
    @Test
    void scrollBGTwoWithXLessThanNegativeSevenHundredTest(){
        gamePanelTestObject.background2.setX(-701);
        gamePanelTestObject.scrollBG();
        assertEquals(700,  gamePanelTestObject.background2.getX());
    }


    /**
     * Test case for scrollGround using Graph Partitioning
     * Covers:  Node, Edge Coverage
     *
     * Test case 01: For path 1
     */

    @Test
    void scrollGroundWithPathOneTest(){
        gamePanelTestObject.ground1.setX(200);
        gamePanelTestObject.scrollGround();
        assertEquals(198,  gamePanelTestObject.ground1.getX());
    }

    /**
     * Test case for scrollGround using Graph Partitioning
     * Test case 02: For path 2
     *
     */
    @Test
    void scrollGroundWithPathTwoTest(){
        gamePanelTestObject.ground1.setX(-701);
        gamePanelTestObject.scrollGround();
        assertEquals(700,  gamePanelTestObject.ground1.getX());
    }

    /**
     * Test case for scrollGround using Graph Partitioning
     * Test case 03: For path 3
     *
     */
    @Test
    void scrollGroundWithPathThreeTest(){
        gamePanelTestObject.ground1.setX(200);
        gamePanelTestObject.scrollGround();
        assertEquals(198,  gamePanelTestObject.ground1.getX());
    }

    /**
     * Test case for scrollGround using Graph Partitioning
     * Test case 04: For path 4
     *
     */
    @Test
    void scrollGroundWithPathFourTest(){
        gamePanelTestObject.ground1.setX(-701);
        gamePanelTestObject.scrollGround();
        assertEquals(700,  gamePanelTestObject.ground1.getX());
    }


    /**
     * Test case for flap using Input Space Partitioning
     *
     */
    @Test
    void flapWithPartitionOneTest() {
        gamePanelTestObject.bird.setY(10);
        int expected = 4;
        gamePanelTestObject.flap();
        assertEquals(expected, gamePanelTestObject.bird.getY());
    }


    @Test
    void flapWithPartitionTwoTest() {
        gamePanelTestObject.bird.setY(0);
        int expected = -6;
        gamePanelTestObject.flap();
        assertEquals(expected, gamePanelTestObject.bird.getY());
    }

    @Test
    void flapWithPartitionThreeTest() {
        gamePanelTestObject.bird.setY(-10);
        int expected = -16;
        gamePanelTestObject.flap();
        assertEquals(expected, gamePanelTestObject.bird.getY());
    }


    @Ignore("Paint method NOT feasible for testing/ Covered In UI Testing")
    @Test
    void paint() {
    }

    /**
     * Parameterized test for IncrementScore Method
     */
    @ParameterizedTest
    @MethodSource("providePartitionedValueForIncrementScoreTest")
    void incrementScorePositiveTest(double input, double expected) {
        assertEquals(expected+1.0, gamePanelTestObject.incrementScore(1.0, input), 1);

    }

    /**
     * Parameterized test for IncrementScore Method
     */
    @ParameterizedTest
    @MethodSource("providePartitionedValueForIncrementScoreTest")
    void incrementScoreZeroTest(double input, double expected) {
        assertEquals(expected, gamePanelTestObject.incrementScore(0.0, input), 1);
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
                Arguments.of(-220.0, -220.0)
        );
    }

    /**
     * Test case for checking if 8 walls are created properly
     * Integration tests
     *
     */
    @Test
    void createWallsTest() {
        gamePanelTestObject.createWalls();
        assertNotNull(gamePanelTestObject.walls[1]);
    }


    /**
     * Functional Test with Graph Partition
     * Test case for Collision Or Score
     * Test Case 01: for path one score
     */
    @Test
    void collisionOrScoreForScoreTest() {
        gamePanelTestObject.createWalls();

        gamePanelTestObject.walls[2].setX(10);
        gamePanelTestObject.walls[2].setY(25);
        gamePanelTestObject.walls[2].setWidth(10);
        gamePanelTestObject.walls[2].setHeight(10);

        gamePanelTestObject.walls[4].setX(10);
        gamePanelTestObject.walls[4].setY(30);
        gamePanelTestObject.walls[4].setWidth(10);
        gamePanelTestObject.walls[4].setHeight(10);

        gamePanelTestObject.bird.setX(25);
        gamePanelTestObject.bird.setY(35);
        gamePanelTestObject.bird.setWidth(2);
        gamePanelTestObject.bird.setHeight(2);

        gamePanelTestObject.collisionOrScore();

        assertFalse(gamePanelTestObject.gameOver);
    }

    /**
     * Functional Test with Graph Partition
     * Test case for Collision Or Score
     * Test Case 02: Path 2 - GameOver with Collision
     *
     */
    @Test
    void collisionOrScoreForCollisionTest() {
        gamePanelTestObject.createWalls();

        gamePanelTestObject.walls[1].setX(11);
        gamePanelTestObject.walls[1].setY(9);
        gamePanelTestObject.walls[3].setWidth(10);
        gamePanelTestObject.walls[4].setHeight(1);

        gamePanelTestObject.walls[3].setX(10);
        gamePanelTestObject.walls[3].setY(10);
        gamePanelTestObject.walls[3].setWidth(10);
        gamePanelTestObject.walls[4].setHeight(10);

        gamePanelTestObject.bird.setX(10);
        gamePanelTestObject.bird.setY(10);
        gamePanelTestObject.bird.setWidth(10);
        gamePanelTestObject.bird.setHeight(10);

        gamePanelTestObject.collisionOrScore();

        assertTrue(gamePanelTestObject.gameOver);
    }

    /**
     * Parameterized test for isStarted And setStarted Method
     * Using Input Space Partition
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

    /**
     * Sets gameover to true and Tests the method
     *
     */
    @Test
    void setGameOverTrueTest() {
        gamePanelTestObject.setGameOver(true);
        assertTrue(gamePanelTestObject.isGameOver());
    }

    /**
     * Setting gameover to False and Testing the method
     *
     */
    @Test
    void setGameOverFalseTest(){
        gamePanelTestObject.setGameOver(false);
        assertFalse(gamePanelTestObject.isGameOver());
    }



    @Ignore("keyReleased method NOT feasible for testing, it has no content")
    @Test
    void keyReleased() {
    }

    @Ignore("keyTyped method NOT feasible for testing, it has no content")
    @Test
    void keyTyped() {
    }
}
