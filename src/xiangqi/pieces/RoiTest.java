package xiangqi.pieces;

import org.junit.jupiter.api.Test;
import xiangqi.Piece;
import xiangqi.Position;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RoiTest {

    Roi roi;

    void initRouge() {
        roi = new Roi("r", Piece.Couleur.ROUGE);
    }

    void initNoir() {
        roi = new Roi("r", Piece.Couleur.NOIR);
    }

    // Rouge

    @Test
    void estValideRougeMoveTeeInPalace() {
        initRouge();
        final Position palaceCenter = new Position(8, 4);
        assertTrue(roi.estValide(
                palaceCenter,
                palaceCenter.add(Position.Up())
        ));
        assertTrue(roi.estValide(
                palaceCenter,
                palaceCenter.add(Position.Down())
        ));
        assertTrue(roi.estValide(
                palaceCenter,
                palaceCenter.add(Position.Left())
        ));
        assertTrue(roi.estValide(
                palaceCenter,
                palaceCenter.add(Position.Right())
        ));
    }

    @Test
    void estValideRougeMoveExInPalace() {
        initRouge();
        final Position palaceCenter = new Position(8, 4);
        assertFalse(roi.estValide(
                palaceCenter,
                palaceCenter.add(Position.Up()).add(Position.Left())
        ));
        assertFalse(roi.estValide(
                palaceCenter,
                palaceCenter.add(Position.Up().add(Position.Right()))
        ));
        assertFalse(roi.estValide(
                palaceCenter,
                palaceCenter.add(Position.Down()).add(Position.Left())
        ));
        assertFalse(roi.estValide(
                palaceCenter,
                palaceCenter.add(Position.Down().add(Position.Right()))
        ));
    }

    @Test
    void estValideRougeMoveOutOfPalace() {
        initRouge();
        final Position palaceCenter = new Position(8, 4);
        assertFalse(roi.estValide(
                palaceCenter,
                palaceCenter.add(Position.Left().times(2))
        ));
        assertFalse(roi.estValide(
                palaceCenter,
                palaceCenter.add(Position.Right().times(2))
        ));
        assertFalse(roi.estValide(
                palaceCenter,
                palaceCenter.add(roi.getForwardUnit().times(2))
        ));
    }

    // Noir

    @Test
    void estValideNoirMoveTeeInPalace() {
        initNoir();
        final Position palaceCenter = new Position(1, 4);
        assertTrue(roi.estValide(
                palaceCenter,
                palaceCenter.add(Position.Up())
        ));
        assertTrue(roi.estValide(
                palaceCenter,
                palaceCenter.add(Position.Down())
        ));
        assertTrue(roi.estValide(
                palaceCenter,
                palaceCenter.add(Position.Left())
        ));
        assertTrue(roi.estValide(
                palaceCenter,
                palaceCenter.add(Position.Right())
        ));
    }

    @Test
    void estValideNoirMoveExInPalace() {
        initNoir();
        final Position palaceCenter = new Position(1, 4);
        assertFalse(roi.estValide(
                palaceCenter,
                palaceCenter.add(Position.Up()).add(Position.Left())
        ));
        assertFalse(roi.estValide(
                palaceCenter,
                palaceCenter.add(Position.Up().add(Position.Right()))
        ));
        assertFalse(roi.estValide(
                palaceCenter,
                palaceCenter.add(Position.Down()).add(Position.Left())
        ));
        assertFalse(roi.estValide(
                palaceCenter,
                palaceCenter.add(Position.Down().add(Position.Right()))
        ));
    }

    @Test
    void estValideNoirMoveOutOfPalace() {
        initNoir();
        final Position palaceCenter = new Position(1, 4);
        assertFalse(roi.estValide(
                palaceCenter,
                palaceCenter.add(Position.Left().times(2))
        ));
        assertFalse(roi.estValide(
                palaceCenter,
                palaceCenter.add(Position.Right().times(2))
        ));
        assertFalse(roi.estValide(
                palaceCenter,
                palaceCenter.add(roi.getForwardUnit().times(2))
        ));
    }
}











