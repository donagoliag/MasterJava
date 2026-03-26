package les_classes_et_objets;

import javax.swing.plaf.PanelUI;

/*
Soit la classe Point ainsi définie :
class Point
{ public Point (int abs, int ord) { x = abs ; y = ord ; }
public void affiche ()
{ System.out.println ("Coordonnees " + x + " " + y) ;
}
private double x ; // abscisse
private double y ; // ordonnee
}

Lui ajouter une méthode maxNorme déterminant parmi deux points lequel est le plus éloi-
gné de l’origine et le fournissant en valeur de retour. On donnera deux solutions :
• maxNorme est une méthode statique de Point,
• maxNorme est une méthode usuelle de Point.

*/
public class Exo_38_Emploidethis {
    public Exo_38_Emploidethis (int abs, int ord) { x = abs ; y = ord ; }
    public void affiche ()
    { System.out.println ("Coordonnees " + x + " " + y) ;
    }
    private double x ; // abscisse
    private double y ; // ordonnee

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    //Maxnorm USUELLE

    public Exo_38_Emploidethis maxNorm(Exo_38_Emploidethis B) {

        if (Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2)) > Math.sqrt(Math.pow(B.x, 2) + Math.pow(B.y, 2))) {
            return this;
        } else {
            return B;
        }

    }

    //Maxnorm STATIC

    public static Exo_38_Emploidethis maxNormStat (Exo_38_Emploidethis A, Exo_38_Emploidethis B) {

        if (Math.sqrt(Math.pow(A.x, 2) + Math.pow(A.y, 2)) > Math.sqrt(Math.pow(B.x, 2) + Math.pow(B.y, 2))) {
            return A;
        } else {
            return B;
        }

    }

    public static void main(String[] args){
        Exo_38_Emploidethis A = new Exo_38_Emploidethis( 2,2);
        Exo_38_Emploidethis B = new Exo_38_Emploidethis(1,1);

        System.out.println("Point le plus loin : (" + (A.maxNorm(B)).getX() + "," + (A.maxNorm(B)).getY() + ")");
        System.out.println( "Point le plus loin : (" + maxNormStat(A,B).getX() + "," + maxNormStat(A,B).getY() + ")");
    }
}


