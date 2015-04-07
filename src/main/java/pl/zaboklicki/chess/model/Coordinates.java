package pl.zaboklicki.chess.model;

/**
 * Created by zabian on 25.03.15.
 */
public class Coordinates {

    private int row;
    private int col;

    private Coordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public static Coordinates create(int row, int col) {
        return new Coordinates(row, col);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinates)) return false;

        Coordinates that = (Coordinates) o;

        if (row != that.row) return false;
        return col == that.col;

    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
