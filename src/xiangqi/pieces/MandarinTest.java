package xiangqi.pieces;

import org.junit.jupiter.api.Test;
import xiangqi.Piece;
import xiangqi.Position;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MandarinTest {

    Mandarin mandarin;

    Position palaceCenter;

    void initRouge() {
        mandarin = new Mandarin("r1", Piece.Couleur.ROUGE);
        palaceCenter = new Position(8, 4);
    }

    void initNoir() {
        mandarin = new Mandarin("r1", Piece.Couleur.NOIR);
        palaceCenter = new Position(1, 4);
    }

    // Rouge

    @Test
    void estValideRougeMoveExInPalace() {
        initRouge();
        assertTrue(mandarin.estValide(
                palaceCenter,
                palaceCenter.add(Position.Up()).add(Position.Left())
        ));
        assertTrue(mandarin.estValide(
                palaceCenter,
                palaceCenter.add(Position.Up().add(Position.Right()))
        ));
        assertTrue(mandarin.estValide(
                palaceCenter,
                palaceCenter.add(Position.Down()).add(Position.Left())
        ));
        assertTrue(mandarin.estValide(
                palaceCenter,
                palaceCenter.add(Position.Down().add(Position.Right()))
        ));
    }

    @Test
    void estValideRougeMoveOutOfPalace() {
        initRouge();
        assertFalse(mandarin.estValide(
                palaceCenter,
                palaceCenter.add(Position.Left().times(2))
        ));
        assertFalse(mandarin.estValide(
                palaceCenter,
                palaceCenter.add(Position.Right().times(2))
        ));
        assertFalse(mandarin.estValide(
                palaceCenter,
                palaceCenter.add(mandarin.getForwardUnit().times(2))
        ));
    }

    @Test
    void estValideRougeMoveTeeInPalace() {
        initRouge();
        assertFalse(mandarin.estValide(
                palaceCenter,
                palaceCenter.add(Position.Up())
        ));
        assertFalse(mandarin.estValide(
                palaceCenter,
                palaceCenter.add(Position.Down())
        ));
        assertFalse(mandarin.estValide(
                palaceCenter,
                palaceCenter.add(Position.Left())
        ));
        assertFalse(mandarin.estValide(
                palaceCenter,
                palaceCenter.add(Position.Right())
        ));
    }

    // Noir

    @Test
    void estValideNoirMoveExInPalace() {
        initNoir();
        assertTrue(mandarin.estValide(
                palaceCenter,
                palaceCenter.add(Position.Up()).add(Position.Left())
        ));
        assertTrue(mandarin.estValide(
                palaceCenter,
                palaceCenter.add(Position.Up().add(Position.Right()))
        ));
        assertTrue(mandarin.estValide(
                palaceCenter,
                palaceCenter.add(Position.Down()).add(Position.Left())
        ));
        assertTrue(mandarin.estValide(
                palaceCenter,
                palaceCenter.add(Position.Down().add(Position.Right()))
        ));
    }

    @Test
    void estValideNoirMoveTeeInPalace() {
        initNoir();
        assertFalse(mandarin.estValide(
                palaceCenter,
                palaceCenter.add(Position.Up())
        ));
        assertFalse(mandarin.estValide(
                palaceCenter,
                palaceCenter.add(Position.Down())
        ));
        assertFalse(mandarin.estValide(
                palaceCenter,
                palaceCenter.add(Position.Left())
        ));
        assertFalse(mandarin.estValide(
                palaceCenter,
                palaceCenter.add(Position.Right())
        ));
    }

    @Test
    void estValideNoirMoveOutOfPalace() {
        initNoir();
        assertFalse(mandarin.estValide(
                palaceCenter,
                palaceCenter.add(Position.Left().times(2))
        ));
        assertFalse(mandarin.estValide(
                palaceCenter,
                palaceCenter.add(Position.Right().times(2))
        ));
        assertFalse(mandarin.estValide(
                palaceCenter,
                palaceCenter.add(mandarin.getForwardUnit().times(2))
        ));
    }

}