package pl.zaboklicki.chess.taking;

import pl.zaboklicki.chess.model.Coordinates;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zabian on 25.03.15.
 */
public class KingTakingStrategy extends ShiftTakingStrategy {

    public static final Set<Coordinates> shifts = new HashSet<Coordinates>(Arrays.asList(
            Coordinates.create(-1, -1), Coordinates.create(-1, 0),
            Coordinates.create(-1, 1),
            Coordinates.create(0, -1), Coordinates.create(0, 1),
            Coordinates.create(1, -1), Coordinates.create(1, 0),
            Coordinates.create(1, 1)));

    @Override
    public Set<Coordinates> getShifts() {
        return shifts;
    }

}
