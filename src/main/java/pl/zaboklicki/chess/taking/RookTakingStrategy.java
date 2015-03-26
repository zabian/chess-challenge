package pl.zaboklicki.chess.taking;

import pl.zaboklicki.chess.model.Board;
import pl.zaboklicki.chess.model.Field;

/**
 * Created by zabian on 26.03.15.
 */
public class RookTakingStrategy extends TakingStrategy {

    @Override
    public void take(Board gameBoard, int i, int j) {
        for (int k = 0; k < gameBoard.getRows(); k++) {
            if (k == i) {
                continue;
            }
            gameBoard.setField(k, j, Field.createTakingField());
        }
        for (int k = 0; k < gameBoard.getCols(); k++) {
            if (k == j) {
                continue;
            }
            gameBoard.setField(i, k, Field.createTakingField());
        }
    }
}
