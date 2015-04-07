package pl.zaboklicki.chess.taking;

import pl.zaboklicki.chess.model.Board;
import pl.zaboklicki.chess.model.Coordinates;

/**
 * Created by zabian on 18.03.2015.
 */
public interface TakingStrategy {

    void take(Board gameBoard, int i, int j);
    boolean isTaking(Coordinates pieceCoordinates, Coordinates coordinatesToCheck);

}
