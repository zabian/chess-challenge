package pl.zaboklicki.chess;

import static org.junit.Assert.*;

public class QueenTakingStrategyTest {

    @org.junit.Test
    public void testTake() throws Exception {
        Board gameBoard = Board.createGameBoard(5, 5);
        QueenTakingStrategy queenTakingStrategy = new QueenTakingStrategy();
        queenTakingStrategy.take(gameBoard, 2, 2);
        Field field = gameBoard.getField(0, 0);
        assert field != null;
        assert field.getState() == FieldState.TAKING;
        field = gameBoard.getField(0, 1);
        assert field == null;
        gameBoard.print();
    }
}