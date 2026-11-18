package xiangqi.pieces;

import org.junit.jupiter.api.Test;
import xiangqi.Piece;
import xiangqi.Position;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CharTest {

    Char aChar;
    Position startPos;

    void initRouge() {
        aChar = new Char("c", Piece.Couleur.ROUGE);
        startPos = new Position(8, 2);
    }

    void initNoir() {
        aChar = new Char("c", Piece.Couleur.NOIR);
        startPos = new Position(1, 2);
    }

    // Rouge

    @Test
    void estValideRougeMoveOneInTee() {
        initRouge();
        assertTrue(aChar.estValide(
                startPos,
                startPos.add(Position.Up())
        ));
        assertTrue(aChar.estValide(
                startPos,
                startPos.add(Position.Down())
        ));
        assertTrue(aChar.estValide(
                startPos,
                startPos.add(Position.Left())
        ));
        assertTrue(aChar.estValide(
                startPos,
                startPos.add(Position.Right())
        ));
    }

    @Test
    void estValideRougeMoveOneDiagonal() {
        initRouge();
        assertFalse(aChar.estValide(
                startPos,
                startPos.add(Position.Up().add(Position.Left()))
        ));
        assertFalse(aChar.estValide(
                startPos,
                startPos.add(Position.Up().add(Position.Right()))
        ));
        assertFalse(aChar.estValide(
                startPos,
                startPos.add(Position.Down().add(Position.Left()))
        ));
        assertFalse(aChar.estValide(
                startPos,
                startPos.add(Position.Down().add(Position.Right()))
        ));
    }

    // Noir

    @Test
    void estValideNoirMoveOneInTee() {
        initNoir();
        assertTrue(aChar.estValide(
                startPos,
                startPos.add(Position.Up())
        ));
        assertTrue(aChar.estValide(
                startPos,
                startPos.add(Position.Down())
        ));
        assertTrue(aChar.estValide(
                startPos,
                startPos.add(Position.Left())
        ));
        assertTrue(aChar.estValide(
                startPos,
                startPos.add(Position.Right())
        ));
    }

    @Test
    void estValideNoirMoveOneDiagonal() {
        initNoir();
        assertFalse(aChar.estValide(
                startPos,
                startPos.add(Position.Up().add(Position.Left()))
        ));
        assertFalse(aChar.estValide(
                startPos,
                startPos.add(Position.Up().add(Position.Right()))
        ));
        assertFalse(aChar.estValide(
                startPos,
                startPos.add(Position.Down().add(Position.Left()))
        ));
        assertFalse(aChar.estValide(
                startPos,
                startPos.add(Position.Down().add(Position.Right()))
        ));
    }
}