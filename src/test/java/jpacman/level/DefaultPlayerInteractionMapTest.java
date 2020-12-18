package jpacman.level;
import jpacman.board.Unit;
import jpacman.npc.Ghost;
import jpacman.points.DefaultPointCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyZeroInteractions;

public class DefaultPlayerInteractionMapTest extends CollisionMapTest{

    CollisionMapTest rando = new DefaultPlayerInteractionMapTest();

    private Player player = mock(Player.class);
    private Ghost ghost = mock(Ghost.class);
    private Pellet pellet = mock(Pellet.class);
    private Unit unit = mock(Unit.class);

    @Test
    public void GhostCollidesPellet() {
        CollisionMap map = new DefaultPlayerInteractionMap(new DefaultPointCalculator());
        map.collide(ghost, pellet);
        verifyZeroInteractions(ghost);
        verifyZeroInteractions(pellet);
    }

    @Test
    public void GhostCollidesPellet2() {
        CollisionMap map = new DefaultPlayerInteractionMap(new DefaultPointCalculator());
        map.collide(ghost, pellet);
        verifyZeroInteractions(ghost);
        verifyZeroInteractions(pellet);
    }

    @Test
    public void GhostCollidesPellet3() {
        CollisionMap map = new DefaultPlayerInteractionMap(new DefaultPointCalculator());
        map.collide(ghost, pellet);
        verifyZeroInteractions(ghost);
        verifyZeroInteractions(pellet);
    }

    @Test
    public void GhostCollidesPellet4() {
        CollisionMap map = new DefaultPlayerInteractionMap(new DefaultPointCalculator());
        map.collide(ghost, pellet);
        verifyZeroInteractions(ghost);
        verifyZeroInteractions(pellet);
    }

    @Test
    public void GhostCollidesPellet5() {
        CollisionMap map = new DefaultPlayerInteractionMap(new DefaultPointCalculator());
        map.collide(ghost, pellet);
        verifyZeroInteractions(ghost);
        verifyZeroInteractions(pellet);
    }

    @Test
    public void GhostCollidesPellet6() {
        CollisionMap map = new DefaultPlayerInteractionMap(new DefaultPointCalculator());
        map.collide(ghost, pellet);
        verifyZeroInteractions(ghost);
        verifyZeroInteractions(pellet);
    }

    @Test
    public void GhostCollidesPellet7() {
        CollisionMap map = new DefaultPlayerInteractionMap(new DefaultPointCalculator());
        map.collide(ghost, pellet);
        verifyZeroInteractions(ghost);
        verifyZeroInteractions(pellet);
    }

}
