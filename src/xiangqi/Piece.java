package xiangqi;

public abstract class Piece {
    /**
     * classe abstraite Piece servant de point de départ pour tous les types de pièces d'un jeu de Xiangqi
     * @author Éric Labonté
     * @version 3
     */

    /**
     * nom de la pièce selon les conventions
     */
    private String nom;

    public enum Couleur {
        NOIR, ROUGE
    }

    /**
     * couleur de la pièce
     */
    private Couleur couleur;

    protected enum Type {
        BOMBARDE,
        CAVALIER,
        CHAR,
        ELEPHANT,
        MANDARIN,
        PION,
        ROI
    }

    protected abstract Type getType();

// constructeur permettant d'initialiser le nom et la couleur d'un objet Piece

    public Piece(String nom, String couleur) {
        setNom(nom);
        if (couleur.equals("rouge") || couleur.equals("noir"))
            setCouleur(couleur.equals("rouge") ? Couleur.ROUGE : Couleur.NOIR);
        else throw new RuntimeException("Wrong Couleur " + couleur);
    }

    public Piece(String nom, Couleur couleur) {
        setNom(nom);
        setCouleur(couleur);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Couleur getCouleur() {
        return this.couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    /**
     * méthode permettant de calculer la norme mathématique entre deux Positions
     *
     * @param depart  Position de départ
     * @param arrivee Position d'arrivée de la Pièce
     * @return la somme des carrés des distances
     *
     */
    public double norme(Position depart, Position arrivee) {
        return Math.pow((depart.getLigne() - arrivee.getLigne()), 2) + Math.pow((depart.getColonne() - arrivee.getColonne()), 2);
    }

    /* méthode abstraite à implémenter dans chacune des sous - classes */

    public abstract boolean estValide(Position depart, Position arrivee);

    public boolean isOnRedSide(Position position) {
        return position.getLigne() > 4;
    }

    public boolean isInPalace(Position position) {
        return betweenInclusive(position.getColonne(), 3, 5) &&
                ((this.couleur == Couleur.NOIR) ?
                        betweenInclusive(position.getLigne(), 0, 2)
                        : betweenInclusive(position.getLigne(), 7, 9));
    }

    boolean betweenInclusive(int x, int min, int max) {
        return x >= min && x <= max;
    }

    public Position getForwardUnit() {
        return switch (this.couleur) {
            case NOIR -> Position.Down();
            case ROUGE -> Position.Up();
        };
    }

    public Position getBackwardUnit() {
        return switch (this.couleur) {
            case NOIR -> Position.Up();
            case ROUGE -> Position.Down();
        };
    }

    public Position moveForwardBy(int steps, Position depart) {
        return depart.add(getForwardUnit().times(steps));
    }

    public boolean onOwnSide(Position position) {
        return switch (this.couleur) {
            case ROUGE -> this.isOnRedSide(position);
            case NOIR -> !this.isOnRedSide(position);
        };
    }

    public boolean passedRiver(Position position) {
        return !onOwnSide(position);
    }

}
