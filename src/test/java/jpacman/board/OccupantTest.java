package jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        // Remove the following placeholder:
        assertThat(!unit.hasSquare());
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
        // Remove the following placeholder:
        BasicSquare targetSquare = new BasicSquare();
        unit.occupy(targetSquare);
        Square currentSquare = unit.getSquare();

        assertThat(currentSquare).isEqualTo(targetSquare);

        List<Unit> Occupants = targetSquare.getOccupants();
        Unit onlyOccupant = Occupants.get(0);
        assertThat(onlyOccupant).isEqualTo(unit);
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        // Remove the following placeholder:
        BasicSquare targetSquare = new BasicSquare();
        unit.occupy(targetSquare);
        Square currentSquare = unit.getSquare();

        assertThat(currentSquare).isEqualTo(targetSquare);

        unit.occupy(targetSquare);
        assertThat(currentSquare).isEqualTo(targetSquare);

    }
}
