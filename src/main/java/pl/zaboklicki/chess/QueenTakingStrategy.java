package pl.zaboklicki.chess;

/**
 * Created by zabian on 18.03.2015.
 */
public class QueenTakingStrategy extends TakingStrategy {

    public void take(Board gameBoard, int i, int j) {
        for (int k = i - 1; k >= 0 ; k--) {
            int distance = (i - k);
            if (j - distance >= 0) {
                gameBoard.setField(k, j - distance, Field.createTakingField());
            }
            if (j + distance <= gameBoard.getCols() - 1) {
                gameBoard.setField(k, j + distance, Field.createTakingField());
            }
        }
        for (int k = i + 1; k < gameBoard.getRows(); k++) {
            int distance = (k - i);
            if (j - distance >= 0) {
                gameBoard.setField(k, j - distance, Field.createTakingField());
            }
            if (j + distance <= gameBoard.getCols() - 1) {
                gameBoard.setField(k, j + distance, Field.createTakingField());
            }
        }
    }

}
