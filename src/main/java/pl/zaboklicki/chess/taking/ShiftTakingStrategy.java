package pl.zaboklicki.chess.taking;

import pl.zaboklicki.chess.model.Board;
import pl.zaboklicki.chess.model.Coordinates;
import pl.zaboklicki.chess.model.Field;

/**
 * Created by zabian on 25.03.15.
 */
public abstract class ShiftTakingStrategy extends TakingStrategy {

    @Override
    public void take(Board gameBoard, int i, int j) {
        for (Coordinates shift : getShifts()) {
            int shiftedRow = i + shift.getRow();
            if (shiftedRow < 0 || shiftedRow > gameBoard.getRows() - 1) {
                continue;
            }
            int shiftedCol = j + shift.getCol();
            if (shiftedCol < 0 || shiftedCol > gameBoard.getCols() - 1) {
                continue;
            }
            gameBoard.setField(shiftedRow, shiftedCol, Field.createTakingField());
        }
    }

    public abstract Coordinates[] getShifts();
}
