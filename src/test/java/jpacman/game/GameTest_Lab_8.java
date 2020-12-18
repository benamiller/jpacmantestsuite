package jpacman.game;
import jpacman.Launcher;
import jpacman.board.Direction;
import jpacman.board.Square;
import jpacman.board.Unit;
import jpacman.game.Game;
import jpacman.level.Level;
import jpacman.level.MapParser;
import jpacman.level.Pellet;
import jpacman.level.Player;
import jpacman.npc.Ghost;
import jpacman.npc.ghost.Navigation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import jpacman.Launcher;
import jpacman.game.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameTest_Lab_8 {

    private Game game;
    private Launcher launcher;
    private MapParser mapParser;
    private Player player;
    private Ghost ghost;

    private void setCustomMap(String path) {
        launcher.dispose(); // Dispose of default map
        launcher = new Launcher();
        launcher = launcher.withMapFile(path); // Create new map with simpler map file
        launcher.launch(); // Launch new game with simple map
        game = launcher.getGame();
        game.start(); // Start the game
    }

    @BeforeEach
    public void setup() {
        launcher = new Launcher();
        launcher.launch();
        game = launcher.getGame();
        game.start();
    }

    @AfterEach
    void tearDown() {
        launcher.dispose();
    }


    // Check the transition from playing to player when the player moves to a
    //      valid square
    @Test
    public void PlayingToPlayingWhenPlayerMoves() {
        player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();
        game.move(player, Direction.WEST);
        assertThat(game.isInProgress()).isTrue();
    }

    // Transition from playing to lose when pacman is eaten
    @Test
    public void PlayingToPacmanDiesTest() {
        setCustomMap("/simplemap.txt");
        ghost = mock(Ghost.class);
        player = game.getPlayers().get(0);
        Square originalPos = player.getSquare();
        assertThat(originalPos.getOccupants().get(0) == player);
        assertThat(player.isAlive());
        game.move(player, Direction.NORTH);
        game.move(player, Direction.WEST);
        assertThat(player.getScore() == 0);
        player.setAlive(false);
        player.setKiller(ghost);
        game.levelLost();
        assertThat(player.isAlive()).isFalse();
        assertThat(game.isInProgress()).isFalse();

    }


    // Check the transition from playing to win when all pellets collected
    @Test
    public void PlayingToPlayerWinsTest() {
        setCustomMap("/singlePellet.txt");
        player = game.getPlayers().get(0);
        Square originalPos = player.getSquare();
        assertThat(originalPos.getOccupants().get(0) == player);
        assertThat(player.getScore() == 0);
        game.move(player, Direction.EAST);
        assertThat(player.getScore() == 10);
        game.levelWon();
        assertThat(game.isInProgress()).isFalse();
    }


    // Check transition from playing to halted when pause button clicked
    @Test
    void PlayingToStopTest() {
        assertThat(game.isInProgress()).isTrue();
        game.stop();
        assertThat(game.isInProgress()).isFalse();
    }

    // Check transition from halted to playing when resume button clicked
    @Test
    void StopToPlayingTest() {
        assertThat(game.isInProgress()).isTrue();
        game.stop();
        assertThat(game.isInProgress()).isFalse();
        game.start();
        assertThat(game.isInProgress()).isTrue();
    }
}
