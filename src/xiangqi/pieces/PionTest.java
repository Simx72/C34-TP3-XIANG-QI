package xiangqi.pieces;

import org.junit.jupiter.api.Test;
import xiangqi.Piece;
import xiangqi.Position;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PionTest {

    Pion pion;

    void initRouge() {
        pion = new Pion("p1", Piece.Couleur.ROUGE);
    }

    void initNoir() {
        pion = new Pion("p1", Piece.Couleur.NOIR);
    }

    // Rouge

    @Test
    void estValideRougeFirstMoveForwards() {
        initRouge();
        assertTrue(pion.estValide(
                new Position(6, 0),
                new Position(5, 0)
        ));
    }

    @Test
    void estValideRougeFirstMoveBackwards() {
        initRouge();
        assertFalse(pion.estValide(
                new Position(6, 0),
                new Position(7, 0)
        ));
    }

    @Test
    void estValideRougeFirstMoveSideways() {
        initRouge();
        assertFalse(pion.estValide(
                new Position(6, 1),
                new Position(6, 0)
        ));
        assertFalse(pion.estValide(
                new Position(6, 1),
                new Position(6, 2)
        ));
    }

    @Test
    void estValideRougeAfterRiverForwards() {
        initRouge();
        assertTrue(pion.estValide(
                new Position(4, 0),
                new Position(3, 0)
        ));
    }

    @Test
    void estValideRougeAfterRiverBackwards() {
        initRouge();
        assertFalse(pion.estValide(
                new Position(4, 0),
                new Position(5, 0)
        ));
    }

    @Test
    void estValideRougeAfterRiverSideways() {
        initRouge();
        assertTrue(pion.estValide(
                new Position(4, 1),
                new Position(4, 0)
        ));
        assertTrue(pion.estValide(
                new Position(4, 1),
                new Position(4, 2)
        ));
    }

    // Noir

    @Test
    void estValideNoirFirstMoveForwards() {
        initNoir();
        assertTrue(pion.estValide(
                new Position(3, 0),
                new Position(4, 0)
        ));
    }

    @Test
    void estValideNoirFirstMoveBackwards() {
        initNoir();
        assertFalse(pion.estValide(
                new Position(3, 0),
                new Position(2, 0)
        ));
    }

    @Test
    void estValideNoirFirstMoveSideways() {
        initNoir();
        assertFalse(pion.estValide(
                new Position(3, 1),
                new Position(3, 0)
        ));
        assertFalse(pion.estValide(
                new Position(3, 1),
                new Position(3, 2)
        ));
    }

    @Test
    void estValideNoirAfterRiverForwards() {
        initNoir();
        assertTrue(pion.estValide(
                new Position(5, 0),
                new Position(6, 0)
        ));
    }

    @Test
    void estValideNoirAfterRiverBackwards() {
        initNoir();
        assertFalse(pion.estValide(
                new Position(5, 0),
                new Position(4, 0)
        ));
    }

    @Test
    void estValideNoirAfterRiverSideways() {
        initNoir();
        assertTrue(pion.estValide(
                new Position(5, 1),
                new Position(5, 0)
        ));
        assertTrue(pion.estValide(
                new Position(5, 1),
                new Position(5, 2)
        ));
    }
}