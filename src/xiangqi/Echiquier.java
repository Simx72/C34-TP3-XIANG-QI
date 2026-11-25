package xiangqi;

import xiangqi.pieces.Roi;

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
                jeu[x][y] = new Intersection();
            }
        }
    }

    @Override
    public void debuter() {

    }

    @Override
    public Intersection getIntersection(int ligne, int colonne) {
        return jeu[ligne][colonne];
    }

    @Override
    public boolean cheminPossible(Position depart, Position arrivee) {
        return false;
    }

    @Override
    public boolean roisNePouvantPasEtreFaceAFace(Position depart, Position arrivee) {
        List<Intersection> rois = getIntersectionDesRois().toList();
        Intersection roiRouge = rois.stream().filter(r -> r.getPiece().getCouleur().equals(Piece.Couleur.ROUGE)).findFirst().orElseThrow();
        Intersection roiNoir = rois.stream().filter(r -> r.getPiece().getCouleur().equals(Piece.Couleur.NOIR)).findFirst().orElseThrow();

        return false;
    }

    Stream<Intersection> getIntersectionDesRois() {
        return getStream().parallel().filter(i -> i.getPiece() instanceof Roi).limit(2);
    }

    public Stream<Intersection> getStream() {
        return Stream.iterate(0, (Integer i) -> i + 1).limit(WIDTH * HEIGHT).map(i -> getIntersection(i / WIDTH, i % WIDTH));
    }

    public Stream<Intersection> getLigneStream(int ligne) {
        return Stream.iterate(0, (Integer c) -> c + 1).limit(WIDTH).map(c -> getIntersection(ligne, c));
    }

    public Stream<Intersection> getColonneStream(int colonne) {
        return Stream.iterate(0, (Integer l) -> l + 1).limit(HEIGHT).map(l -> getIntersection(l, colonne));
    }
}
