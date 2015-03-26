package pl.zaboklicki.chess.taking;

import pl.zaboklicki.chess.model.Coordinates;

/**
 * Created by zabian on 25.03.15.
 */
public class KingTakingStrategy extends ShiftTakingStrategy {

    private static final Coordinates[] shifts = {
            Coordinates.create(-1, -1), Coordinates.create(-1, 0),
            Coordinates.create(-1, 1),
            Coordinates.create(0, -1), Coordinates.create(0, 1),
            Coordinates.create(1, -1), Coordinates.create(1, 0),
            Coordinates.create(1, 1)
    };

    @Override
    public Coordinates[] getShifts() {
        return shifts;
    }
}
