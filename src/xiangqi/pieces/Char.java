package xiangqi.pieces;

import xiangqi.Piece;
import xiangqi.Position;

public class Char extends Piece {
    public Char(String nom, Couleur couleur) {
        super(nom, couleur);
    }

    public Char(String nom, String couleur) {
        super(nom, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        return depart.getLigne() == arrivee.getLigne() || depart.getColonne() == arrivee.getColonne();
    }

    @Override
    protected Piece.Type getType() {
        return Type.CHAR;
    }
}
