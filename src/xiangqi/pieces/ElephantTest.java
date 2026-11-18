package xiangqi.pieces;

import org.junit.jupiter.api.Test;
import xiangqi.Piece;
import xiangqi.Position;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ElephantTest {
    Elephant elephant;
    Position startPos;

    void initRouge() {
        elephant = new Elephant("e", Piece.Couleur.ROUGE);
        startPos = new Position(9, 2);
    }

    void initNoir() {
        elephant = new Elephant("e", Piece.Couleur.NOIR);
        startPos = new Position(0, 2);
    }

    // Rouge

    @Test
    void estValideRougeMoveTwoDiagonal() {
        initRouge();
        assertTrue(elephant.estValide(
                startPos,
                startPos.add(Position.Up().add(Position.Left()).times(2))
        ));
        assertTrue(elephant.estValide(
                startPos,
                startPos.add(Position.Up().add(Position.Right()).times(2))
        ));
    }

    @Test
    void estValideRougeMoveOneDiagonal() {
        initRouge();
        assertFalse(elephant.estValide(
                startPos,
                startPos.add(Position.Up().add(Position.Left()))
        ));
        assertFalse(elephant.estValide(
                startPos,
                startPos.add(Position.Up().add(Position.Right()))
        ));
    }

    @Test
    void estValideRougeMoveInTee() {
        initRouge();
        assertFalse(elephant.estValide(
                startPos,
                startPos.add(elephant.getForwardUnit())
        ));
        assertFalse(elephant.estValide(
                startPos,
                startPos.add(Position.Left())
        ));
        assertFalse(elephant.estValide(
                startPos,
                startPos.add(Position.Right())
        ));
    }

    // Noir

    @Test
    void estValideNoirMoveTwoDiagonal() {
        initNoir();
        assertTrue(elephant.estValide(
                startPos,
                startPos.add(Position.Down().add(Position.Left()).times(2))
        ));
        assertTrue(elephant.estValide(
                startPos,
                startPos.add(Position.Down().add(Position.Right()).times(2))
        ));
    }

    @Test
    void estValideNoirMoveOneDiagonal() {
        initNoir();
        assertFalse(elephant.estValide(
                startPos,
                startPos.add(Position.Down().add(Position.Left()))
        ));
        assertFalse(elephant.estValide(
                startPos,
                startPos.add(Position.Down().add(Position.Right()))
        ));
    }

    @Test
    void estValideNoirMoveInTee() {
        initNoir();
        assertFalse(elephant.estValide(
                startPos,
                startPos.add(elephant.getForwardUnit())
        ));
        assertFalse(elephant.estValide(
                startPos,
                startPos.add(Position.Left())
        ));
        assertFalse(elephant.estValide(
                startPos,
                startPos.add(Position.Right())
        ));
    }

}