package xiangqi.pieces;

import xiangqi.Piece;
import xiangqi.Position;

public class Cavalier extends Piece {
    public Cavalier(String nom, Couleur couleur) {
        super(nom, couleur);
    }

    public Cavalier(String nom, String couleur) {
        super(nom, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        if (depart.equals(arrivee)) {
            return true;
        }
        return this.norme(depart, arrivee) == 5;
    }

    @Override
    protected Piece.Type getType() {
        return Type.CAVALIER;
    }
}
