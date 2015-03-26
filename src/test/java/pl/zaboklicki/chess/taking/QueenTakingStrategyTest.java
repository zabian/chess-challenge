package pl.zaboklicki.chess.taking;

import pl.zaboklicki.chess.model.Board;
import pl.zaboklicki.chess.model.Coordinates;
import pl.zaboklicki.chess.model.Field;
import pl.zaboklicki.chess.model.FieldState;

public class QueenTakingStrategyTest extends AbstractTakingStrategyTest {

    @Override
    public TakingStrategy getTakingStrategy() {
        return new QueenTakingStrategy();
    }

    @Override
    public Coordinates[] getTakingCoordinates() {
        return new Coordinates[] {
            Coordinates.create(1, 1),
            Coordinates.create(1, 2),
            Coordinates.create(1, 3),
            Coordinates.create(2, 1),
            Coordinates.create(2, 3),
            Coordinates.create(3, 1),
            Coordinates.create(3, 2),
            Coordinates.create(3, 3)
        };
    }

    @Override
    public Coordinates[] getFreeCoordinates() {
        return new Coordinates[] {
            Coordinates.create(0, 1),
            Coordinates.create(0, 3),
            Coordinates.create(1, 0),
            Coordinates.create(1, 4),
            Coordinates.create(3, 0),
            Coordinates.create(3, 4),
            Coordinates.create(4, 1),
            Coordinates.create(4, 3)
        };
    }
}