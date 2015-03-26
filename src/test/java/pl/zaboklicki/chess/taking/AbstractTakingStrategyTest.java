package pl.zaboklicki.chess.taking;

import org.junit.Before;
import org.junit.Test;
import pl.zaboklicki.chess.model.Board;
import pl.zaboklicki.chess.model.Coordinates;
import pl.zaboklicki.chess.model.Field;
import pl.zaboklicki.chess.model.FieldState;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by zabian on 25.03.15.
 */
public abstract class AbstractTakingStrategyTest {

    TakingStrategy takingStrategy;
    Board gameBoard;

    @Before
    public void setUp() throws Exception {
        takingStrategy = getTakingStrategy();
        gameBoard = Board.createGameBoard(5, 5);
    }

    @Test
    public void testTaking() {
        System.out.println("Testing " + takingStrategy.getClass().getSimpleName());
        takingStrategy.take(gameBoard, 2, 2);
        gameBoard.print();
        System.out.println("Checking taken fields");
        for (Coordinates takingCoordinate : getTakingCoordinates()) {
            System.out.println(takingCoordinate);
            Field field = gameBoard.getField(takingCoordinate.getCol(), takingCoordinate.getRow());
            assertThat(field).isNotNull();
//            if (takingCoordinate.getRow() == 1 && takingCoordinate.getCol() == 1) {
//                continue;
//            }
            assertThat(field.getState()).isEqualTo(FieldState.TAKING);
        }
        System.out.println("Checking free fields");
        for (Coordinates freeCoordinate : getFreeCoordinates()) {
            System.out.println(freeCoordinate);
            Field field = gameBoard.getField(freeCoordinate.getCol(), freeCoordinate.getRow());
            assertThat(field).isNull();
        }
    }

    public abstract TakingStrategy getTakingStrategy();
    public abstract Coordinates[] getTakingCoordinates();
    public abstract Coordinates[] getFreeCoordinates();


}
