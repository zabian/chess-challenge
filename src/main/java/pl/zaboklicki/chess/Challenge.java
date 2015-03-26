package pl.zaboklicki.chess;

import pl.zaboklicki.chess.model.Board;
import pl.zaboklicki.chess.model.Field;
import pl.zaboklicki.chess.model.FieldState;
import pl.zaboklicki.chess.model.Piece;
import pl.zaboklicki.chess.taking.TakingException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zabian on 19.03.2015.
 */
public class Challenge {

    private int[] piecesCount = new int[Piece.values().length];
    private int rows;
    private int cols;
    private int kings;
    private int queens;
    private int bishops;
    private int rooks;
    private int knights;

    public int solve() {
        List<Piece> pieces = new ArrayList<Piece>(kings + queens + bishops + rooks + knights);
        int halfrow = (rows + 1) / 2;
        int halfcol = (cols + 1) / 2;

        for (Piece piece : Piece.values()) {
            int pieceCount = piecesCount[piece.ordinal()];
            for (int i = 0; i < pieceCount; i++) {
                pieces.add(piece);
            }
        }

//        List<Piece> pieceList = new ArrayList<Piece>();
        Set<Piece> processed = new HashSet<Piece>();
        for (Piece piece : pieces) {
            if (processed.contains(piece)) {
                continue;
            }
            if (!pieces.contains(piece)) {
                continue;
            }
            for (int i = 0; i < halfrow; i++) {
                for (int j = 0; j < halfcol; j++) {
                    Board gameBoard = Board.createGameBoard(rows, cols);
                    try {
                        gameBoard.setField(i, j, Field.createField(piece));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    ArrayList<Piece> piecesCopy = new ArrayList<Piece>(pieces);
                    piecesCopy.remove(piece);
                    Board clone = gameBoard.clone();
                    solveRecursive(clone, piecesCopy, i, j);
                    processed.add(piece);
                }
            }
        }

        return 0;
    }

    private void solveRecursive(Board board, List<Piece> pieces, int startcol, int startrow) {
        Set<Piece> processed = new HashSet<Piece>();
         for (Piece piece : pieces) {
//             System.out.println(piece);
            if (processed.contains(piece)) {
                continue;
            }
            processed.add(piece);
            for (int i = 0; i < board.getCols(); i++) {
                for (int j = 0; j < board.getRows(); j++) {
                    if (i < startrow && j < startcol) {
                        continue;
                    }
                    Field field = board.getField(i, j);
                    if (field != null && field.getState() == FieldState.TAKING) {
                        continue;
                    }
                    if (i == board.getRows() && j == board.getCols()) {

                    }
                    Board gameBoard = board.clone();
                    try {
                        gameBoard.setField(i, j, Field.createField(piece));
                    } catch (TakingException e) {
//                        gameBoard.print();
                        continue;
                    }
                    List<Piece> piecesCopy = new ArrayList<Piece>(pieces);
                    piecesCopy.remove(piece);
                    if (piecesCopy.isEmpty()) {
                        gameBoard.print();
                        System.out.println();
                        continue;
                    }
                    solveRecursive(gameBoard.clone(), piecesCopy, i, j);
                }
            }
        }
    }

    private Challenge(Builder builder) {
        piecesCount[Piece.KING.ordinal()] = builder.kings;
        piecesCount[Piece.QUEEN.ordinal()] = builder.queens;
        piecesCount[Piece.BISHOP.ordinal()] = builder.bishops;
        piecesCount[Piece.ROOK.ordinal()] = builder.rooks;
        piecesCount[Piece.KNIGHT.ordinal()] = builder.knights;

        rows = builder.rows;
        cols = builder.cols;
        kings = builder.kings;
        queens = builder.queens;
        bishops = builder.bishops;
        rooks = builder.rooks;
        knights = builder.knights;
    }

    public static Builder builder(int m, int n) {
        return new Builder(m, n);
    }

    public static class Builder {

        private int rows;
        private int cols;
        private int kings;
        private int queens;
        private int bishops;
        private int rooks;
        private int knights;

        private Builder(int rows, int cols) {
            if (rows < 1 || cols < 1) {
                throw new IllegalArgumentException("Board dimension must be positive number");
            }
            this.rows = rows;
            this.cols = cols;
        }

        public Builder kings(int count) {
            this.kings = count;
            return this;
        }

        public Builder queens(int count) {
            this.queens = count;
            return this;
        }

        public Builder bishops(int count) {
            this.bishops = count;
            return this;
        }

        public Builder rooks(int count) {
            this.rooks = count;
            return this;
        }

        public Builder knights(int count) {
            this.knights = count;
            return this;
        }

        public Challenge build() {
            return new Challenge(this);
        }
    }

}
