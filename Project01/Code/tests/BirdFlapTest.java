import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Ignore("Tests are not feasible for this class")
class BirdFlapTest {

    private BirdFlap birdFlapTest;

    GamePanel panel = new GamePanel();
    Component bird = new Component(0, 0, 700, 490, "images//bird.png");

    @BeforeEach
    void setUp() {
        birdFlapTest = new BirdFlap(panel, bird);
    }

    @AfterEach
    void tearDown() {
        birdFlapTest = null;
    }

    @Ignore("Not feasible for this method")
    @Test
    void run() {

    }
}