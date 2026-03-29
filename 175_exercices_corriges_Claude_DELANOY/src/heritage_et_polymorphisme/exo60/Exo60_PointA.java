package heritage_et_polymorphisme.exo60;
/*On dispose de la classe suivante :
class Point
{ public void initialise (int x, int y) { this.x = x ; this.y = y ; }
public void deplace (int dx, int dy) { x += dx ; y += dy ; }
public int getX() { return x ; }
public int getY() { return y ; }
private int x, y ;
}
Réaliser une classe PointA, dérivée de Point disposant d’une méthode affiche affichant (en
fenêtre console) les coordonnées d’un point. Ecrire un petit programme utilisant les deux
classes Point et PointA.
Que se passerait-il si la classe Point ne disposait pas des méthodes getX et getY ?*/
public class Exo60_PointA extends Point{

    public void affiche(){
        System.out.println("("+this.getX()+" , "+ this.getY()+")");
    }

    public static void main(String[] args){
        Point A = new Point();
        A.initialise(2,3);
        System.out.println(A.getX()+"_"+A.getY());

        Exo60_PointA B = new Exo60_PointA();
        B.initialise(4,9);
        B.deplace(2,1);
        B.affiche();
    }
}
