package xiangqi;

public class Intersection {
    private Piece piece;

    public Intersection(Piece piece) {
        this.piece = piece;
    }

    public Intersection() {
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean estOccupee() {
        return getPiece() != null;
    }
}
