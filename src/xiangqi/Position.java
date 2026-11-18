package xiangqi;

import org.jetbrains.annotations.NotNull;

public class Position {
    private int ligne; // de 0 à 9 voir schéma
    private int colonne; // de 0 à 8

    public Position(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
    }

    public static Position Up() {
        return new Position(-1, 0);
    }

    public static Position Down() {
        return new Position(1, 0);
    }

    public static Position Right() {
        return new Position(0, 1);
    }

    public static Position Left() {
        return new Position(0, -1);
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public boolean equals(Position pos) {
        if (pos == null) {
            return false;
        }
        return this.getLigne() == pos.getLigne() && this.getColonne() == pos.getColonne();
    }

    public Position add(@NotNull Position pos) {
        return new Position(
                this.getLigne() + pos.getLigne(),
                this.getColonne() + pos.getColonne()
        );
    }

    public Position times(int k) {
        return new Position(
                this.getLigne() * k,
                this.getColonne() * k
        );
    }
}
