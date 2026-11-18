package xiangqi.pieces;

import org.junit.jupiter.api.Test;
import xiangqi.Piece;
import xiangqi.Position;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CavalierTest {
    Cavalier cavalier;
    final Position boardCenter = new Position(5, 4);

    void initRouge() {
        cavalier = new Cavalier("c", Piece.Couleur.ROUGE);
    }

    void initNoir() {
        cavalier = new Cavalier("c", Piece.Couleur.NOIR);
    }

    void checkLMovements() {
        assertTrue(cavalier.estValide(
                boardCenter,
                boardCenter.add(Position.Up().times(2).add(Position.Left()))
        ));
        assertTrue(cavalier.estValide(
                boardCenter,
                boardCenter.add(Position.Up().times(2).add(Position.Right()))
        ));
        assertTrue(cavalier.estValide(
                boardCenter,
                boardCenter.add(Position.Down().times(2).add(Position.Left()))
        ));
        assertTrue(cavalier.estValide(
                boardCenter,
                boardCenter.add(Position.Down().times(2).add(Position.Right()))
        ));
        assertTrue(cavalier.estValide(
                boardCenter,
                boardCenter.add(Position.Up().add(Position.Left().times(2)))
        ));
        assertTrue(cavalier.estValide(
                boardCenter,
                boardCenter.add(Position.Up().add(Position.Right().times(2)))
        ));
        assertTrue(cavalier.estValide(
                boardCenter,
                boardCenter.add(Position.Down().add(Position.Left().times(2)))
        ));
        assertTrue(cavalier.estValide(
                boardCenter,
                boardCenter.add(Position.Down().add(Position.Right().times(2)))
        ));
    }

    @Test
    void estValideRougeMoveInL() {
        initRouge();
        checkLMovements();
    }

    @Test
    void estValideNoirMoveInL() {
        initNoir();
        checkLMovements();
    }


}