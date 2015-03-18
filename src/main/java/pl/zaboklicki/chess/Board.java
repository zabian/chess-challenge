package pl.zaboklicki.chess;

/**
 * Created by zabian on 18.03.2015.
 */
public class Board {

    private Field[][] fields;
    private int n;
    private int m;

    private Board(int n, int m) {
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException("board dimensions have to be positive numbers");
        }
        this.n = n;
        this.m = m;
        this.fields = new Field[n][m];
    }

    public static Board createGameBoard(final int n, final int m) {
        Board board = new Board(n, m);
        return board;
    }

    public int getRows() {
        return n;
    }

    public int getCols() {
        return m;
    }

    public void setField(int i, int j, Field field) throws TakingException {
        if (fields[i][j] != null) {
            throw new TakingException();
        }
        fields[i][j] = field;
    }

    public Field getField(int i,final int j) {
        return fields[i][j];
    }

    public void print() {
        System.out.println("abc");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
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
