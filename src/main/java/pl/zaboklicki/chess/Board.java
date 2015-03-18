package pl.zaboklicki.chess;

/**
 * Created by zabian on 18.03.2015.
 */
public class Board {

    private Field[][] fields;

    public Board(Field[][] fields) {
        this.fields = fields;
    }

    public Board(int n, int m) {
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException("board dimensions have to be positive numbers");
        }
        this.fields = new Field[n][m];
    }
}
