package jpacman.game;


import jpacman.level.Level;
import jpacman.level.Player;
import jpacman.points.PointCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class GameStartTest {
    private Level level;
    private Player player;
    private SinglePlayerGame game;

    @BeforeEach
    void setUp() {
        level = mock(Level.class);
        player = mock(Player.class);
        game = new SinglePlayerGame(player, level, mock(PointCalculator.class));
    }

    @Test
    void deadStart() {
        when(level.isAnyPlayerAlive()).thenReturn(false);
        game.start();
        verify(level, never()).start();
        assertThat(game.isInProgress()).isFalse();
    }

    @Test
    void gameInProgress() {
        when(level.isAnyPlayerAlive()).thenReturn(true);
        when(level.remainingPellets()).thenReturn(3);
        game.start();
        verify(level).start();
        assertThat(game.isInProgress()).isTrue();
    }

    @Test
    void aliveStart() {
        when(level.isAnyPlayerAlive()).thenReturn(true);
        when(level.remainingPellets()).thenReturn(3);
        game.start();
        //verify(level, never()).start();
        assertThat(game.isInProgress()).isTrue();
    }

}
