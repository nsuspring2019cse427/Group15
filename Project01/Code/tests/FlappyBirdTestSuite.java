import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("JUnit FlappyBird Test Suite")
@SelectClasses({BirdFlapTest.class, GamePanelTest.class, ComponentTest.class, GameSoundTest.class})

public class FlappyBirdTestSuite {
    /**
     * Test Suite for FlappyBird Test Classes
     *
     */
}
