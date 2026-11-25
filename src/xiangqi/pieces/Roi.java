package xiangqi.pieces;

import xiangqi.Piece;
import xiangqi.Position;

public class Roi extends Piece {
    public Roi(String nom, Couleur couleur) {
        super(nom, couleur);
    }

    public Roi(String nom, String couleur) {
        super(nom, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        if (depart.equals(arrivee)) {
            return true;
        }
        // s'il a bougé de 0 ou 1 pas
        final boolean moveOne = this.norme(depart, arrivee) == 1;
        // et s'il reste toujours dans le palais
        final boolean isInPalace = isInPalace(arrivee);
        return moveOne && isInPalace;
    }
}
