package xiangqi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import xiangqi.pieces.*;

class PieceTest {

    @Test
    void stayInPositionWorks() {
        for (final Piece.Couleur couleur : Piece.Couleur.values()) {
            final Piece[] allPieces = new Piece[7];
            allPieces[0] = new Roi("r", couleur);
            allPieces[1] = new Mandarin("m", couleur);
            allPieces[2] = new Elephant("e", couleur);
            allPieces[3] = new Cavalier("c", couleur);
            allPieces[4] = new Char("t", couleur);
            allPieces[5] = new Bombarde("b", couleur);
            allPieces[6] = new Pion("p", couleur);
            for (final Piece piece : allPieces) {
                for (int l = 0; l < 10; l++) {
                    for (int c = 0; c < 9; c++) {
                        final boolean shouldBeTrue = piece.estValide(
                                new Position(l, c),
                                new Position(l, c)
                        );
//                        if (!shouldBeTrue) {
//                            IO.println("Err in l = " + l + " & c = " + c + " in " + piece.getNom() + " " + piece.getCouleur().toString());
//                        }
                        Assertions.assertTrue(shouldBeTrue);
                    }
                }
            }
        }
    }

}