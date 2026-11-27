package xiangqi.pieces;

import xiangqi.Piece;
import xiangqi.Position;

public class Mandarin extends Piece {
    public Mandarin(String nom, Couleur couleur) {
        super(nom, couleur);
    }

    public Mandarin(String nom, String couleur) {
        super(nom, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        if (depart.equals(arrivee)) {
            return true;
        }
        return isInPalace(arrivee) && this.norme(depart, arrivee) == 2;
    }

    @Override
    protected Piece.Type getType() {
        return Type.MANDARIN;
    }
}
