package pl.zaboklicki.chess.taking;

import pl.zaboklicki.chess.model.Board;
import pl.zaboklicki.chess.model.Coordinates;
import pl.zaboklicki.chess.model.Field;

/**
 * Created by zabian on 18.03.2015.
 */
public class QueenTakingStrategy implements TakingStrategy {

    public void take(Board gameBoard, int i, int j) {
        for (int k = 0; k < gameBoard.getRows(); k++) {
            int distance = Math.abs(i - k);
            if (distance > 0) {
                if (j - distance >= 0) {
                    gameBoard.setField(k, j - distance, Field.createTakingField());
                }
                if (j + distance <= gameBoard.getCols() - 1) {
                    gameBoard.setField(k, j + distance, Field.createTakingField());
                }
                gameBoard.setField(k, j, Field.createTakingField());
                continue;
            }
            for (int l = 0; l < gameBoard.getCols(); l++) {
                if (l == j) {
                    continue;
                }
                gameBoard.setField(k, l, Field.createTakingField());
            }
        }
    }

    public boolean isTaking(Coordinates pieceCoordinates, Coordinates coordinatesToCheck) {
        if (coordinatesToCheck.getRow() == pieceCoordinates.getRow()
                || coordinatesToCheck.getCol() == pieceCoordinates.getCol()) {
            return true;
        }
        return Math.abs(coordinatesToCheck.getRow() - pieceCoordinates.getRow())
                == Math.abs(coordinatesToCheck.getCol() - pieceCoordinates.getCol());
    }

}
