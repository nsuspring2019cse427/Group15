import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

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
         *
         */
        assertTrue(gamePanelTestObject.Start());
    }

    @Test
    void gravityPullTest() {
        gamePanelTestObject.gravityPull();
    }

    @Test
    void scrollWalls() {
    }

    @Test
    void scrollBG() {
    }

    @Test
    void scrollGround() {
    }


    @Disabled("Paint method NOT feasible for testing")
    @Test
    void paint() {
        //gamePanelTestObject.paint();
    }

    @Test
    void checkCollision() {
    }

    @Test
    void keyPressed() {
    }

    @Test
    void incrementScore() {
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