package pl.zaboklicki.chess.taking;

import pl.zaboklicki.chess.model.Coordinates;

import static org.junit.Assert.*;

/**
 * Created by zabian on 26.03.15.
 */
public class KingTakingStrategyTest extends AbstractTakingStrategyTest {

    @Override
    public TakingStrategy getTakingStrategy() {
        return new KingTakingStrategy();
    }

    @Override
    public Coordinates[] getTakingCoordinates() {
        return new Coordinates[] {
            Coordinates.create(1, 1),
            Coordinates.create(3, 1),
            Coordinates.create(1, 3),
            Coordinates.create(3, 3),
            Coordinates.create(1, 2),
            Coordinates.create(2, 1),
            Coordinates.create(2, 3),
            Coordinates.create(3, 2)
        };
    }

    @Override
    public Coordinates[] getFreeCoordinates() {
        return new Coordinates[] {
            Coordinates.create(0, 0),
            Coordinates.create(0, 1)
        };
    }
}