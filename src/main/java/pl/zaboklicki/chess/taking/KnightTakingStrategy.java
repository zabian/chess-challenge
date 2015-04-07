package pl.zaboklicki.chess.taking;

import pl.zaboklicki.chess.model.Coordinates;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zabian on 24.03.2015.
 */
public class KnightTakingStrategy extends ShiftTakingStrategy {

    public static final Set<Coordinates> shifts = new HashSet<Coordinates>(Arrays.asList(
            Coordinates.create(-2, -1), Coordinates.create(-2, 1),
            Coordinates.create(2, -1), Coordinates.create(2, 1),
            Coordinates.create(-1, -2), Coordinates.create(1, -2),
            Coordinates.create(-1, 2), Coordinates.create(1, 2)));

    @Override
    public Set<Coordinates> getShifts() {
        return shifts;
    }
}
