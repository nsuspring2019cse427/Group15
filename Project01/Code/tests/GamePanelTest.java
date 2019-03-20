import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void start() {
        /**
         * Test to check game can start by calling Start method.
         * There
         */
        assertTrue(gamePanelTestObject.Start());
    }

    @Test
    void gravity() {
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

    @Test
    void paint() {
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

    @Test
    void isGameOver() {
    }

    @Test
    void setGameOver() {
    }

    @Test
    void keyReleased() {
    }

    @Test
    void keyTyped() {
    }
}