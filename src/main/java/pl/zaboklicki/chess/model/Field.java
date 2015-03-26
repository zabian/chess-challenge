package pl.zaboklicki.chess.model;

/**
 * Created by zabian on 18.03.2015.
 */
public class Field {

    private Piece piece;
    private FieldState state = FieldState.FREE;

    private Field() {
    }

    public static Field createField(Piece piece) {
        Field field = new Field();
        field.piece = piece;
        field.state = FieldState.BUSY;
        return field;
    }

    public static Field createTakingField() {
        Field field = new Field();
        field.state = FieldState.TAKING;
        return field;
    }

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
