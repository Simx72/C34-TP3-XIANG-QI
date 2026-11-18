package xiangqi.pieces;

import xiangqi.Piece;
import xiangqi.Position;

public class Pion extends Piece {
    public Pion(String nom, Couleur couleur) {
        super(nom, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        final Couleur couleur = this.getCouleur();
        // le pion peut toujours rester sur place
        if (depart.equals(arrivee)) {
            return true;
        }
        // le pion peut toujours avancer
        else if (depart.add(this.getForwardUnit()).equals(arrivee)) {
            return true;
        }
        // si le pion a passé la rivière, il peut bouger de côté
        else return this.passedRiver(arrivee) &&
                    arrivee.getLigne() == depart.getLigne() &&
                    Math.abs(arrivee.getColonne() - depart.getColonne()) == 1;
    }
}
