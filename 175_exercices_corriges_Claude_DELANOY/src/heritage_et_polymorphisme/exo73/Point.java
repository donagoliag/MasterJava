package heritage_et_polymorphisme.exo73;

public class Point {
    public Point (double x, double y) { this.x=x ; this.y=y ; }
    public void deplace (double dx, double dy) { x+=dx ; y+=dy ; }
    public void affiche ()
    { System.out.println ("Point de coordonnees " + x + " " + y) ;
    }
    public double getX() { return x ; }
    public double getY() { return y ; }
    private double x, y ;
}
