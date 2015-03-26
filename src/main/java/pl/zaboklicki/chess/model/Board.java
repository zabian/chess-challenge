package pl.zaboklicki.chess.model;

import pl.zaboklicki.chess.taking.TakingException;

/**
 * Created by zabian on 18.03.2015.
 */
public class Board {

    private Field[][] fields;
    private int cols;
    private int rows;

    private Board(int cols, int rows) {
        if (cols <= 0 || rows <= 0) {
            throw new IllegalArgumentException("board dimensions have to be positive numbers");
        }
        this.cols = cols;
        this.rows = rows;
        this.fields = new Field[cols][rows];
    }

    public static Board createGameBoard(final int n, final int m) {
        Board board = new Board(n, m);
        return board;
    }

    public int getRows() {
        return cols;
    }

    public int getCols() {
        return rows;
    }

    public void setField(int i, int j, Field field) throws TakingException {
        Field f = fields[i][j];
        if (f == null || f.getState() == FieldState.FREE) {
            fields[i][j] = field;
            if (field.getPiece() != null) {
                field.getPiece().take(this, i, j);
            }
            return;
        }
        if (field.getState() == FieldState.TAKING
                && f.getState() == FieldState.TAKING) {
            return;
        }
        throw new TakingException();
    }

    public Field getField(int i, int j) {
        return fields[i][j];
    }

    public Board clone() {
        Board board = new Board(cols, rows);
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                board.fields[i][j] = this.fields[i][j];
            }
        }
        return board;
    }

    public void print() {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (j > 0) {
                    System.out.print(" ");
                }
                Field field = fields[i][j];
                if (field == null || field.getState() == FieldState.FREE) {
                    System.out.print("0");
                    continue;
                }
                if (field.getState() == FieldState.TAKING) {
                    System.out.print("T");
                    continue;
                }
                System.out.print(field.getPiece().name().charAt(0));
            }
            System.out.println();
        }
    }
}
