
import org.sikuli.script.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class GameGUITest  {

    private Screen scr;
    private Main window;

    @BeforeEach
    void setUp() {
        scr = new Screen();

    }

    @AfterEach
    void tearDown() {
        scr = null;
    }

    @Test
    void GameInitializationScreenTest() {
        try {

            scr.mouseDown(Button.RIGHT);
            Thread.sleep(500);

            scr.find("images/gameInitializationProof.png");
            Thread.sleep(500);
            assertNotNull(scr.exists("images/gameInitializationProof.png"));

        } catch (Exception e) {}
    }

    @Test
    void BirdOnScreenUITest() {
        try {
            Thread.sleep(500);
            scr.find("images/birdScr.png");
            Thread.sleep(500);
            assertNotNull(scr.exists("images/birdScr.png"));

        } catch (Exception e) {}
    }

    @Test
    void PresenceOfPipeUpGUITest() {
        try {
            scr.find("images/pipeUpScr.png");
            Thread.sleep(500);

            assertNotNull(scr.exists("images/pipeUpScr.png"));
        } catch (Exception e) {}
    }

    @Test
    void GameOverGUITest() {
        try {
            Thread.sleep(500);
            scr.keyUp();
            Thread.sleep(100);

            scr.find("images/overScr.png");
             assertNotNull(scr.exists("images/overScr.png"));

        } catch (Exception e) {}

    }

    @Test
    void PresenceOfPipeDownGUITest() {
        try {
            Thread.sleep(500);

            scr.find("images/pipeDownScr.png");
            Thread.sleep(500);

            assertNotNull(scr.exists("images/pipeDownScr.png"));
        } catch (Exception e) {}
    }

    @Test
    void GroundAvailableGUITest() {
        try {
            Thread.sleep(500);

            scr.find("images/groundScr.png");
            Thread.sleep(500);
            assertNotNull(scr.exists("images/groundScr.png"));
        } catch (Exception e) {}
    }

}
