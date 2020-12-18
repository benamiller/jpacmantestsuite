package jpacman.npc.ghost;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

import jpacman.PacmanConfigurationException;
import jpacman.board.Board;
import jpacman.board.BoardFactory;
import jpacman.board.Square;
import jpacman.level.*;
import jpacman.npc.Ghost;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;


public class MapParserTest {

    private LevelFactory levelFactory;
    private BoardFactory boardFactory;
    private MapParser mapParser;
    private GhostFactory ghostFactory;
    private PlayerFactory playerFactory;


    @BeforeEach
    void setUp() {
        levelFactory = mock(LevelFactory.class);
        boardFactory = mock(BoardFactory.class);
        ghostFactory = mock(GhostFactory.class);
        mapParser = new MapParser(levelFactory, boardFactory);
    }


    // Himmat's code
    @Test
    void parsePellet() {
        Square square = mock(Square.class);
        when(boardFactory.createGround()).thenReturn(square);

        Pellet pellet = mock(Pellet.class);
        when(levelFactory.createPellet()).thenReturn(pellet);

        mapParser.parseMap(singletonList("."));

        verify(boardFactory).createGround();
        verify(levelFactory).createPellet();
    }

    //Good Weather
    @Test
    void parseEmptySquare() {
        mapParser.parseMap(singletonList(" "));
        verify(boardFactory).createGround();
    }

    @Test
    void parseWall() {
        mapParser.parseMap(singletonList("#"));
        verify(boardFactory).createWall();
    }

    @Test
    void parsePelletSquare() {
        Square square = mock(Square.class);
        when(boardFactory.createGround()).thenReturn(square);

        Pellet pellet = mock(Pellet.class);

        when(levelFactory.createPellet()).thenReturn(pellet);


        mapParser.parseMap(singletonList("."));
        verify(boardFactory).createGround();
        verify(levelFactory).createPellet();
        verify(pellet).occupy(square);
    }

    @Test
    void parseGhost() {
        /* Could not figure out mock ghost */

        Square square = mock(Square.class);
        when(boardFactory.createGround()).thenReturn(square);

        Ghost ghost = mock(Ghost.class);
        when(levelFactory.createGhost()).thenReturn(ghost);

        mapParser.parseMap(singletonList("G"));
        verify(boardFactory).createGround();
        verify(levelFactory).createGhost();
        verify(ghost).occupy(square);

    }

    @Test
    void parsePlayer() {

        Square square = mock(Square.class);
        when(boardFactory.createGround()).thenReturn(square);

        Player player = mock(Player.class);

        mapParser.parseMap(singletonList("P"));
        verify(boardFactory).createGround();
        verify(levelFactory).createLevel(any(), anyList(), eq(singletonList(square)));

    }


    /*~~~~~~~~~~~~~~~~~~~*/
    //Bad Weather

    @Test
    void parseLengthsOfRowsNotEqualFirstSmaller() {
        assertThatThrownBy(()->mapParser.parseMap(asList("#","##"))).isInstanceOf(PacmanConfigurationException.class);
    }

    @Test
    void parseLengthsOfRowsNotEqualSecondSmaller() {
        assertThatThrownBy(()->mapParser.parseMap(asList("##","#"))).isInstanceOf(PacmanConfigurationException.class);
    }

    @Test
    void parseNoMap() {
        assertThatThrownBy(()->mapParser.parseMap((""))).isInstanceOf(PacmanConfigurationException.class);
    }

    @Test
    void parseMultipleEmptyLines() {
        assertThatThrownBy(()->mapParser.parseMap(asList("", "", "", "", ""))).isInstanceOf(PacmanConfigurationException.class);
    }

}
