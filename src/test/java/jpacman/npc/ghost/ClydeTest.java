package jpacman.npc.ghost;
import com.google.common.collect.Lists;
import jpacman.board.BoardFactory;
import jpacman.board.Direction;
import jpacman.level.*;
import jpacman.npc.ghost.GhostFactory;
import jpacman.npc.ghost.GhostMapParser;
import jpacman.points.PointCalculatorLoader;
import jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import jpacman.board.Board;
import jpacman.board.Square;
import jpacman.level.Level;
import jpacman.npc.Ghost;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*
public class ClydeTest {
    private GhostMapParser parser;
    private Player pacman;

    @BeforeEach
    void setUp(){
        PacManSprites sprites = new PacManSprites();
        PlayerFactory playerFactory = new PlayerFactory(sprites);

        pacman = playerFactory.createPacMan();

        BoardFactory boardFactory = new BoardFactory(sprites);
        GhostFactory ghostFactory = new GhostFactory(sprites);
        LevelFactory levelFactory = new LevelFactory(sprites, ghostFactory, new PointCalculatorLoader().load());

        parser = new GhostMapParser(levelFactory, boardFactory, ghostFactory);

    }

    @Test
    void clydeFirstTest() {
        List<String> map = Lists.newArrayList("####", "#P.#");
        parser.parseMap(map);
        pacman.setDirection(Direction.EAST);
        Square temp =  pacman.squaresAheadOf(1);
        pacman.occupy(temp);
        assertThat(pacman.getSquare() == temp);
    }

    @Test
    void clydeSecondTest() {
        List<String> map = Lists.newArrayList("####", "#P.#");
        parser.parseMap(map);
        //Navigation.findUnitInBoard();
    }

    @Test
    void clydeThirdTest() {
        List<String> map = Lists.newArrayList("####", "#P.#");
        parser.parseMap(map);
        //Navigation.findUnitInBoard();
    }
}
*/