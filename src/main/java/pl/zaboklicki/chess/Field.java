package pl.zaboklicki.chess;

/**
 * Created by zabian on 18.03.2015.
 */
public class Field {

    private Piece piece;
    private FieldState state;

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public FieldState getState() {
        return state;
    }

    public void setState(FieldState state) {
        this.state = state;
    }
}
