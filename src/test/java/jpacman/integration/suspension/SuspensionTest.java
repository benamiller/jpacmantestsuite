package jpacman.integration.suspension;

import jpacman.Launcher;
import jpacman.game.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SuspensionTest {
    private Game game;
    private Launcher launcher;

    @BeforeEach
    public void setup() {
        launcher = new Launcher();
        launcher.launch();
        game = launcher.getGame();
        game.start();
    }

    @AfterEach
    void tearDown() { launcher.dispose(); }

    // Exercise 1
    // A test to check scenario 4.1, game suspension
    @Test
    void suspendTest() {
        assertThat(game.isInProgress()).isTrue();
        game.stop();
        assertThat(game.isInProgress()).isFalse();
    }

    // A test to check scenario 4.2, game resume
    @Test
    void restartTest() {
        assertThat(game.isInProgress()).isTrue();
        game.stop();
        assertThat(game.isInProgress()).isFalse();
        game.start();
        assertThat(game.isInProgress()).isTrue();
    }


}
