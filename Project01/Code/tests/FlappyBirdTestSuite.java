import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("JUnit FlappyBird Test Suite")
@SelectClasses({BirdFlapTest.class, GamePanelTest.class, ComponentTest.class, GameSoundTest.class, GameSoundTestForException.class, GameGUITest.class})

public class FlappyBirdTestSuite {
    
    /**
     * Test Suite for FlappyBird Test Classes
     * Automation of the test suite, This class runs tests automatically from 
     * all other test class that are added by SelectClasses Annotation. No extra codes required
     */
    
    /**
     * JUnit 5 was Used to build the test suite
     * In Junit 5 Theory is Dead
     * So, No presence of Theory. but the job of theory was done by Paramaterized Extension
     *
     *
     */
}
