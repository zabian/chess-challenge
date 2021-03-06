package pl.zaboklicki.chess.taking;

import pl.zaboklicki.chess.model.Board;
import pl.zaboklicki.chess.model.Coordinates;
import pl.zaboklicki.chess.model.Field;

/**
 * Created by zabian on 25.03.15.
 */
public class BishopTakingStrategy implements TakingStrategy {

    public void take(Board gameBoard, int i, int j) {
        for (int k = 0; k < gameBoard.getRows(); k++) {
            int distance = Math.abs(i - k);
            if (distance == 0) {
                continue;
            }
            if (j - distance >= 0) {
                gameBoard.setField(k, j - distance, Field.createTakingField());
            }
            if (j + distance <= gameBoard.getCols() - 1) {
                gameBoard.setField(k, j + distance, Field.createTakingField());
            }
        }
    }

    public boolean isTaking(Coordinates pieceCoordinates, Coordinates coordinatesToCheck) {
        return Math.abs(coordinatesToCheck.getRow() - pieceCoordinates.getRow())
                == Math.abs(coordinatesToCheck.getCol() - pieceCoordinates.getCol());
    }

}
