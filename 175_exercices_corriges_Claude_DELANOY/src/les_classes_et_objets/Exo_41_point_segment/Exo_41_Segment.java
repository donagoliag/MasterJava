package les_classes_et_objets.Exo_41_point_segment;

/*On dispose de la classe Point suivante permettant de manipuler des points d’un plan.
class Point
{ public Point (double x, double y) { this.x = x ; this.y = y ; }
public void deplace (double dx, double dy) { x += dx ; y += dy ; }
public void affiche ()
{ System.out.println ("coordonnees = " + x + " " + y ) ;
}
private double x, y ;
}
En ajoutant les fonctionnalités nécessaires à la classe Point, réaliser une classe Segment
permettant de manipuler des segments d’un plan et disposant des méthodes suivantes :
segment (Point origine, Point extremite)
segment (double xOr, double yOr, double xExt, double yExt)
double longueur() ;
void deplaceOrigine (double dx, double dy)
void deplaceExtremite (double dx, double dy)
void affiche()*/

public class Exo_41_Segment {

    private Point origine;
    private Point extremite;

    Exo_41_Segment (Point origine, Point extremite) {
     this.origine = origine;
     this.extremite =extremite;
    }

    Exo_41_Segment (double xOr, double yOr, double xExt, double yExt) {
      this.origine = new Point(xOr,yOr);
      this.extremite= new Point(xExt,yExt);
    }

    public double longueur() {
        return Math.sqrt(Math.pow((this.extremite.getY()-this.origine.getY()),2) + Math.pow((this.extremite.getX()-this.origine.getX()),2));
    }

    public void deplaceOrigine (double dx, double dy){
        this.origine.deplace(dx,dy);
    }

    public void deplaceExtremite (double dx, double dy){
        this.extremite.deplace(dx,dy);
    }

    public void affiche(){
        this.origine.affiche();
        this.extremite.affiche();
    }

    public static void main(String[] args) {
        // Création de segments
        Exo_41_Segment seg1 = new Exo_41_Segment(new Point(1, 2), new Point(4, 6));
        Exo_41_Segment seg2 = new Exo_41_Segment(0, 0, 3, 4);

        // Affichage des segments
        System.out.println("Segment 1 :");
        seg1.affiche();
        System.out.println("Longueur segment 1 = " + seg1.longueur());

        System.out.println("\nSegment 2 :");
        seg2.affiche();
        System.out.println("Longueur segment 2 = " + seg2.longueur());

        // Déplacement des points
        seg1.deplaceOrigine(1, 1);
        seg1.deplaceExtremite(-1, -2);

        System.out.println("\nAprès déplacement du segment 1 :");
        seg1.affiche();
        System.out.println("Longueur segment 1 = " + seg1.longueur());
    }
}
