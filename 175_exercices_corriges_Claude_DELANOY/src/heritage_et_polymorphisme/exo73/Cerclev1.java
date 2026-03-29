package heritage_et_polymorphisme.exo73;

/*On dispose de la classe suivante :
class Point
{ public Point (double x, double y) { this.x=x ; this.y=y ; }
public void deplace (double dx, double dy) { x+=dx ; y+=dy ; }
public void affiche ()
{ System.out.println ("Point de coordonnees " + x + " " + y) ;
}
public double getX() { return x ; }
public double getY() { return y ; }
private double x, y ;
}
On souhaite réaliser une classe Cercle disposant des méthodes suivantes :
• constructeur recevant en argument les coordonnées du centre du cercle et son rayon,
• deplaceCentre pour modifier les coordonnées du centre du cercle,
• changeRayon pour modifier le rayon du cercle,
• getCentre qui fournit en résultat un objet de type Point correspondant au centre du
cercle,
• affiche qui affiche les coordonnées du centre du cercle et son rayon.
1. Définir la classe Cercle comme classe dérivée de Point.
2. Définir la classe Cercle comme possédant un membre de type Point.
Dans les deux cas, on écrira un petit programme mettant en jeu les différentes fonctionna-
lités de la classe Cercle.*/

public class Cerclev1 extends Point{
    private double rayon;

    public Cerclev1(double x, double y, double r) {
        super(x,y);
        rayon = r;
    }

    public void deplaceCentre(double x, double y){
        super.deplace(x,y);
    }

    public void changeRayon(double ray){
        this.rayon = ray;
    }

    public Point getCentre(){
        return new Point(super.getX(),super.getY());
    }

    public void affiche(){
        System.out.println("Point de coordonnees " + super.getX() + " " + super.getY() + " et de rayon " + this.rayon);
    }
}

