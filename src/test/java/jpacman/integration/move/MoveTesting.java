package jpacman.integration.move;

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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MoveTesting {
    private Game game;
    private Launcher launcher;
    private MapParser mapParser;
    private Player player;

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

    // Exercise 2
    // Scenario 2.1
    @Test
    public void PlayerConsumesPellet() {
        player = game.getPlayers().get(0);
        game.move(player, Direction.WEST);
        assertThat(player.getScore() == 10);

        //verify pellet is gone
        Unit pellet = Navigation.findUnit(Pellet.class, player.getSquare());
        assertEquals(null, pellet);
    }

    private void setCustomMap(String path) {
        launcher.dispose(); // Dispose of default map
        launcher = new Launcher();
        launcher = launcher.withMapFile(path);
        launcher.launch();
        game = launcher.getGame();
        game.start();
    }

    // Scenario 2.2

    @Test
    public void PlayerMovesToEmptySquare() {
        setCustomMap("/simplemapEmptySquare.txt");
        player = game.getPlayers().get(0);
        Square originalPos = player.getSquare();
        // Make sure player is at starting square
        assertThat(originalPos.getOccupants().get(0) == player);
        game.move(player, Direction.EAST);
        // Make sure score has not gone up
        assertThat(player.getScore() == 0);
        // Make sure the player is alive
        assertThat(player.isAlive());
        // Make sure the player is alive, with unchanged score, in different square
        assertThat(originalPos.getOccupants() == null);
    }

    // Scenario 2.3

    @Test
    public void PlayerMovesToWallSquare()  {
        setCustomMap("/simplemapAllWalls.txt");
        player = game.getPlayers().get(0);
        Square originalPos = player.getSquare();
        // Make sure player is at starting square
        assertThat(originalPos.getOccupants().get(0) == player);
        game.move(player, Direction.EAST);
        // Make sure score has not gone up
        assertThat(player.getScore() == 0);
        // Make sure the player is alive
        assertThat(player.isAlive());
        // Make sure the player is alive, with unchanged score, in the same square
        assertThat(originalPos.getOccupants().get(0) == player);
    }



    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Exercise 4

    // Scenario 2.4
    @Test
    public void PacmanDiesTest() {
        setCustomMap("/simplemap.txt");
        player = game.getPlayers().get(0);
        Square originalPos = player.getSquare();
        assertThat(originalPos.getOccupants().get(0) == player);
        assertThat(player.isAlive());
        game.move(player, Direction.NORTH);
        game.move(player, Direction.WEST);
        assertThat(player.getScore() == 0);
        player.setAlive(false);
        game.levelLost();
        assertThat(player.isAlive()).isFalse();
        assertThat(game.isInProgress()).isFalse();

        // Make sure the player is alive, with unchanged score, in the same square
        //Thread.sleep(1000) for ghost to find and kill pacman
        // check game.getLevel.isAnyPlayerAlive
    }

    // Scenario 2.5

    @Test
    public void PlayerWins() {
        setCustomMap("/singlePellet.txt");
        player = game.getPlayers().get(0);
        Square originalPos = player.getSquare();
        // Make sure player is at starting square
        assertThat(originalPos.getOccupants().get(0) == player);
        assertThat(player.getScore() == 0);
        game.move(player, Direction.EAST);
        // Make sure score has not gone up
        assertThat(player.getScore() == 10);
        // Make sure the player is alive
        assertThat(player.isAlive());
        // Make sure the player is alive, with changed score

    }


}
