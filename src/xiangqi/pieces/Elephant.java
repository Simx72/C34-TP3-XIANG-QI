package xiangqi.pieces;

import xiangqi.Piece;
import xiangqi.Position;

public class Elephant extends Piece {
    public Elephant(String nom, Couleur couleur) {
        super(nom, couleur);
    }

    public Elephant(String nom, String couleur) {
        super(nom, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        if (depart.equals(arrivee)) {
            return true;
        }
        return this.norme(depart, arrivee) == 8 && this.onOwnSide(arrivee);
    }
}
