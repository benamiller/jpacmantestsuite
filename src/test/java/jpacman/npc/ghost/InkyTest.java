package jpacman.npc.ghost;
import jpacman.board.BoardFactory;
import jpacman.level.LevelFactory;
import jpacman.npc.ghost.GhostFactory;
import jpacman.npc.ghost.GhostMapParser;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
/*
public class InkyTest {
    @ParameterizedTest(name = "")
    @CsvSource({
            // First test
            "#", "#","#","#",
            // Second test
            "#","#","#","#",
            // Third
            "#","#","#","#",
            // Fourth
            "#","#","#","#",
    })
    void InkyTests() {
        int result;
        int expectedResult;
        assertThat(expectedResult == result);
    }
}
*/