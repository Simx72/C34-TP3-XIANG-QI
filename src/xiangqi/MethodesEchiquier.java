package xiangqi;
public interface MethodesEchiquier
{
public void debuter();
public Intersection getIntersection( int ligne, int colonne );
public boolean cheminPossible ( Position  depart , Position arrivee);
public boolean roisNePouvantPasEtreFaceAFace ( Position depart,Position arrivee );
}