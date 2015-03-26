package pl.zaboklicki.chess.taking;

import pl.zaboklicki.chess.model.Board;

/**
 * Created by zabian on 18.03.2015.
 */
public abstract class TakingStrategy {

    public abstract void take(Board gameBoard, int i, int j);
}
