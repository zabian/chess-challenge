package pl.zaboklicki.chess.taking;

import pl.zaboklicki.chess.model.Coordinates;

/**
 * Created by zabian on 24.03.2015.
 */
public class KnightTakingStrategy extends ShiftTakingStrategy {

    private static final Coordinates[] shifts = {
            Coordinates.create(-2, -1), Coordinates.create(-2, 1),
            Coordinates.create(2, -1), Coordinates.create(2, 1),
            Coordinates.create(-1, -2), Coordinates.create(1, -2),
            Coordinates.create(-1, 2), Coordinates.create(1, 2)
    };

    @Override
    public Coordinates[] getShifts() {
        return shifts;
    }

}
