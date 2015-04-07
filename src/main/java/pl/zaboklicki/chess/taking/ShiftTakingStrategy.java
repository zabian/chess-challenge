package pl.zaboklicki.chess.taking;

import pl.zaboklicki.chess.model.Board;
import pl.zaboklicki.chess.model.Coordinates;
import pl.zaboklicki.chess.model.Field;

import java.util.Set;

/**
 * Created by zabian on 25.03.15.
 */
public abstract class ShiftTakingStrategy implements TakingStrategy {

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

    public abstract Set<Coordinates> getShifts();

    public boolean isTaking(Coordinates pieceCoordinates, Coordinates coordinatesToCheck) {
        Coordinates shift = Coordinates.create(coordinatesToCheck.getRow() - pieceCoordinates.getRow(),
                coordinatesToCheck.getCol() - pieceCoordinates.getCol());
        return getShifts().contains(shift);
    }
}
