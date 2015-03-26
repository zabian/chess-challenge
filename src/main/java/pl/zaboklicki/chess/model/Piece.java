package pl.zaboklicki.chess.model;

import pl.zaboklicki.chess.taking.*;

/**
 * Created by zabian on 18.03.2015.
 */
public enum Piece {

    KING('K', new KingTakingStrategy()),
    QUEEN('Q', new QueenTakingStrategy()),
    BISHOP('B', new BishopTakingStrategy()),
    ROOK('R', new RookTakingStrategy()),
    KNIGHT('N', new KnightTakingStrategy());

    private char symbol;
    private TakingStrategy takingStrategy;

    Piece(char symbol, TakingStrategy takingStrategy) {
        this.symbol = symbol;
        this.takingStrategy = takingStrategy;
    }

    public char getSymbol() {
        return symbol;
    }

    public void take(Board board, int row, int col) {
//        board.setField(row, col, Field.createField(this));
        takingStrategy.take(board, row, col);
    }
}
