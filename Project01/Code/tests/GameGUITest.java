import org.sikuli.script.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


public class GameGUITest {
        
        @BeforeEach
        void setUp() {
             Screen scr = new Screen();
        }
        
        @AfterEach
        void tearDown() {
                scr = null;
        }
        
        @Test
        void GameInitializationScreenTest() {
                assertNotNull(scr.exist("images//gameInitializtionProof.png"));
        }

}
