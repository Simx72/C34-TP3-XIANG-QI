package xiangqi;

import xiangqi.pieces.*;

import java.util.List;
import java.util.stream.Stream;

public class Echiquier implements MethodesEchiquier {
    public static final int HEIGHT = 10;
    public static final int WIDTH = 9;

    private Intersection[][] jeu;

    public Echiquier() {
        this.jeu = new Intersection[HEIGHT][WIDTH];
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                jeu[y][x] = new Intersection();
            }
        }
    }

    @Override
    public void debuter() {
        for (final Piece.Couleur couleur : Piece.Couleur.values()) {
            final int ligne = couleur == Piece.Couleur.NOIR ? 0 : (HEIGHT - 1);
            this.jeu[couleur.ordinal()][0] = new Intersection(new Char("nt1", couleur));
            this.jeu[couleur.ordinal()][1] = new Intersection(new Cavalier("nc1", couleur));
            this.jeu[couleur.ordinal()][2] = new Intersection(new Elephant("ne1", couleur));
            this.jeu[couleur.ordinal()][3] = new Intersection(new Mandarin("nm1", couleur));
            this.jeu[couleur.ordinal()][4] = new Intersection(new Roi("nr", couleur));
            this.jeu[couleur.ordinal()][5] = new Intersection(new Mandarin("nm2", couleur));
            this.jeu[couleur.ordinal()][6] = new Intersection(new Elephant("ne2", couleur));
            this.jeu[couleur.ordinal()][7] = new Intersection(new Cavalier("nc2", couleur));
            this.jeu[couleur.ordinal()][8] = new Intersection(new Char("nt2", couleur));
        }
    }

    @Override
    public Intersection getIntersection(int ligne, int colonne) {
        return jeu[ligne][colonne];
    }

    @Override
    public boolean cheminPossible(Position depart, Position arrivee) {
        
    }

    @Override
    public boolean roisNePouvantPasEtreFaceAFace(Position startPos, Position endPos) {
        final Intersection start = getIntersection(startPos.getLigne(), startPos.getColonne());
        final Intersection end = getIntersection(endPos.getLigne(), endPos.getColonne());
        final List<IntersectionAvecPosition> rois = getIntersectionRois();
        final IntersectionAvecPosition rougeAvant = rois.stream().filter(p -> p.intersection.getPiece().getCouleur() == Piece.Couleur.ROUGE).findFirst().orElseThrow();
        final IntersectionAvecPosition noirAvant = rois.stream().filter(p -> p.intersection.getPiece().getCouleur() == Piece.Couleur.NOIR).findFirst().orElseThrow();

        // copy game
        final Echiquier jeuCopy = new Echiquier();
        jeuCopy.getStream().forEach(i -> {
            i.intersection.setPiece(
                    getIntersection(i.position.getLigne(), i.position.getColonne()).getPiece()
            );
        });
        // make move
        {
            final Piece startPiece = start.getPiece();
            jeuCopy.getIntersection(startPos.getLigne(), startPos.getColonne()).setPiece(null);
            jeuCopy.getIntersection(endPos.getLigne(), endPos.getColonne()).setPiece(startPiece);
        }

        // if just moved a king
        if (start.getPiece() instanceof Roi) {
            // get the other king
            final IntersectionAvecPosition other =
                    // if start is noir
                    (start.getPiece().getCouleur() == Piece.Couleur.NOIR)
                            ? rougeAvant // other is red
                            : noirAvant; // else, noir
            // return true if "start" not facing "other"
            final boolean sameColumn = endPos.getColonne() == other.position.getColonne();
            final boolean pieceInBetween = jeuCopy.countInsideRect(endPos, other.position) > 2;
            return !sameColumn || pieceInBetween;
        }
        // if moved something that's not a king
        else {
            // return true if "rouge" not facing "noir"
            final boolean sameColumn = rougeAvant.position.getColonne() == noirAvant.position.getColonne();
            final boolean pieceInBetween = jeuCopy.countInsideRect(rougeAvant.position, noirAvant.position) > 2;
            return !sameColumn || pieceInBetween;
        }
    }

    private List<IntersectionAvecPosition> getIntersectionRois() {
        return getStream().parallel().filter(i -> i.intersection.getPiece() instanceof Roi).limit(2).toList();
    }

    private int countInsideRect(Position a, Position b) {
        final int minLigne = Math.min(a.getLigne(), b.getLigne());
        final int maxLigne = Math.max(a.getLigne(), b.getLigne());
        final int minColonne = Math.min(a.getColonne(), b.getColonne());
        final int maxColonne = Math.max(a.getColonne(), b.getColonne());
        int count = 0;
        for (int l = minLigne; l <= maxLigne; l++) {
            for (int c = minColonne; c <= maxColonne; c++) {
                if (getIntersection(l, c).estOccupee()) {
                    count++;
                }
            }
        }
        return count;
    }

    public Stream<IntersectionAvecPosition> getStream() {
        return Stream.iterate(0, (Integer i) -> i + 1)
                .limit(WIDTH * HEIGHT)
                .map(i -> new IntersectionAvecPosition(
                        getIntersection(i / WIDTH, i % WIDTH),
                        new Position(i / WIDTH, i % WIDTH)
                ));
    }

    public Stream<Intersection> getLigneStream(int ligne) {
        return Stream.iterate(0, (Integer c) -> c + 1).limit(WIDTH).map(c -> getIntersection(ligne, c));
    }

    public Stream<Intersection> getColonneStream(int colonne) {
        return Stream.iterate(0, (Integer l) -> l + 1).limit(HEIGHT).map(l -> getIntersection(l, colonne));
    }
}
