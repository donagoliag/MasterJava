package heritage_et_polymorphisme.exo62;

/*
* On dispose de la classe suivante (disposant cette fois d’un constructeur) :
class Point
{ public Point (int x, int y) { this.x = x ; this.y = y ; }
public void affCoord()
{ System.out.println ("Coordonnees : " + x + " " + y) ;
}
private int x, y ;
}
Réaliser une classe PointNom, dérivée de Point permettant de manipuler des points définis
par leurs coordonnées (entières) et un nom (caractère). On y prévoira les méthodes
suivantes :
• constructeur pour définir les coordonnées et le nom d’un objet de type PointNom,
• affCoordNom pour afficher les coordonnées et le nom d’un objet de type PointNom.
Écrire un petit programme utilisant la classe PointNom.*/

public class PointNom extends Point{
    private char nom;

    public PointNom(int x, int y, char nom){
        super(x,y);
        this.nom=nom;
    }

    public void affCoordNom(){
        super.affCoord();
        System.out.println("Nom : " + nom);
    }
}
