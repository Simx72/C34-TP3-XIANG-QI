package xiangqi.pieces;

import xiangqi.Piece;
import xiangqi.Position;

public class Bombarde extends Piece {
    public Bombarde(String nom, Couleur couleur) {
        super(nom, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        return depart.getLigne() == arrivee.getLigne() || depart.getColonne() == arrivee.getColonne();
    }
}
