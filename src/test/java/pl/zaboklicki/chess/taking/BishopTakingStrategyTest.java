package pl.zaboklicki.chess.taking;

import pl.zaboklicki.chess.model.Coordinates;


/**
 * Created by zabian on 25.03.15.
 */
public class BishopTakingStrategyTest extends AbstractTakingStrategyTest {

    @Override
    public TakingStrategy getTakingStrategy() {
        return new BishopTakingStrategy();
    }

    @Override
    public Coordinates[] getTakingCoordinates() {
        return new Coordinates[] {
            Coordinates.create(1, 1),
            Coordinates.create(3, 1),
            Coordinates.create(1, 3),
            Coordinates.create(3, 3)
        };
    }

    @Override
    public Coordinates[] getFreeCoordinates() {
        return new Coordinates[] {
            Coordinates.create(1, 2),
            Coordinates.create(2, 1),
            Coordinates.create(2, 3),
            Coordinates.create(3, 2)
        };
    }

}