package jpacman.level;
import jpacman.board.Unit;
import jpacman.npc.Ghost;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyZeroInteractions;

// Lab 6 abstract class

public abstract class CollisionMapTest {
    private Player player = mock(Player.class);
    private Ghost ghost = mock(Ghost.class);
    private Pellet pellet = mock(Pellet.class);
    private Unit unit = mock(Unit.class);

    private CollisionMap map;

    protected void SetMap(CollisionMap cmap) {
        this.map = cmap;
    }

    /*
    public void GhostCollidesPellet() {
        map.collide(ghost, pellet);
        verifyZeroInteractions(ghost);
        verifyZeroInteractions(pellet);
    }

     */

    public void PlayerCollidesPlayer() {
        Player player2 = mock(Player.class);
        map.collide(player, player2);
        assertThat(player.isAlive()).isTrue();
        assertThat(player2.isAlive()).isTrue();
        verifyZeroInteractions(player);
        verifyZeroInteractions(player2);
    }

    public void PlayerCollidesGhost() {

        map.collide(player, ghost);

    }


}
