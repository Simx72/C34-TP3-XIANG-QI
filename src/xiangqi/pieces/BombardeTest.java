package xiangqi.pieces;

import org.junit.jupiter.api.Test;
import xiangqi.Piece;
import xiangqi.Position;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BombardeTest {
    Bombarde bombarde;
    Position startPos;

    void initRouge() {
        bombarde = new Bombarde("c", Piece.Couleur.ROUGE);
        startPos = new Position(8, 2);
    }

    void initNoir() {
        bombarde = new Bombarde("c", Piece.Couleur.NOIR);
        startPos = new Position(1, 2);
    }

    // Rouge

    @Test
    void estValideRougeMoveOneInTee() {
        initRouge();
        assertTrue(bombarde.estValide(
                startPos,
                startPos.add(Position.Up())
        ));
        assertTrue(bombarde.estValide(
                startPos,
                startPos.add(Position.Down())
        ));
        assertTrue(bombarde.estValide(
                startPos,
                startPos.add(Position.Left())
        ));
        assertTrue(bombarde.estValide(
                startPos,
                startPos.add(Position.Right())
        ));
    }

    @Test
    void estValideRougeMoveOneDiagonal() {
        initRouge();
        assertFalse(bombarde.estValide(
                startPos,
                startPos.add(Position.Up().add(Position.Left()))
        ));
        assertFalse(bombarde.estValide(
                startPos,
                startPos.add(Position.Up().add(Position.Right()))
        ));
        assertFalse(bombarde.estValide(
                startPos,
                startPos.add(Position.Down().add(Position.Left()))
        ));
        assertFalse(bombarde.estValide(
                startPos,
                startPos.add(Position.Down().add(Position.Right()))
        ));
    }

    // Noir

    @Test
    void estValideNoirMoveOneInTee() {
        initNoir();
        assertTrue(bombarde.estValide(
                startPos,
                startPos.add(Position.Up())
        ));
        assertTrue(bombarde.estValide(
                startPos,
                startPos.add(Position.Down())
        ));
        assertTrue(bombarde.estValide(
                startPos,
                startPos.add(Position.Left())
        ));
        assertTrue(bombarde.estValide(
                startPos,
                startPos.add(Position.Right())
        ));
    }

    @Test
    void estValideNoirMoveOneDiagonal() {
        initNoir();
        assertFalse(bombarde.estValide(
                startPos,
                startPos.add(Position.Up().add(Position.Left()))
        ));
        assertFalse(bombarde.estValide(
                startPos,
                startPos.add(Position.Up().add(Position.Right()))
        ));
        assertFalse(bombarde.estValide(
                startPos,
                startPos.add(Position.Down().add(Position.Left()))
        ));
        assertFalse(bombarde.estValide(
                startPos,
                startPos.add(Position.Down().add(Position.Right()))
        ));
    }
}