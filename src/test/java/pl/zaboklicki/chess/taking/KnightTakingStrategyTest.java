package pl.zaboklicki.chess.taking;

import pl.zaboklicki.chess.model.Coordinates;

import static org.junit.Assert.*;

/**
 * Created by zabian on 26.03.2015.
 */
public class KnightTakingStrategyTest extends AbstractTakingStrategyTest {

    @Override
    public TakingStrategy getTakingStrategy() {
        return new KnightTakingStrategy();
    }

    @Override
    public Coordinates[] getTakingCoordinates() {
        return new Coordinates[] {
            Coordinates.create(0, 1),
            Coordinates.create(0, 3),
            Coordinates.create(1, 0),
            Coordinates.create(1, 4),
            Coordinates.create(3, 0),
            Coordinates.create(3, 4),
            Coordinates.create(4, 1),
            Coordinates.create(4, 3),
        };
    }

    @Override
    public Coordinates[] getFreeCoordinates() {
        return new Coordinates[] {
            Coordinates.create(0, 0),
            Coordinates.create(0, 2),
            Coordinates.create(0, 4),
            Coordinates.create(1, 1),
            Coordinates.create(1, 2),
            Coordinates.create(1, 3),
            Coordinates.create(2, 0),
            Coordinates.create(2, 1),
            Coordinates.create(2, 3),
            Coordinates.create(2, 4),
            Coordinates.create(3, 1),
            Coordinates.create(3, 2),
            Coordinates.create(3, 3),
            Coordinates.create(4, 0),
            Coordinates.create(4, 2),
            Coordinates.create(4, 4),
        };
    }
}