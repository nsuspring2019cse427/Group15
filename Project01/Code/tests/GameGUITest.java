
import org.sikuli.script.Screen;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.awt.*;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


public class GameGUITest  {

    private Screen scr;

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
            scr.find("images/gameInitializationProof.png");
            assertNotNull(scr.exists("images/gameInitializationProof.png"));
        } catch (Exception e) {}
    }

}
