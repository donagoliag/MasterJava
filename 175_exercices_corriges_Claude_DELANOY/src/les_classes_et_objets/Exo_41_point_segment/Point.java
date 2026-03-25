package les_classes_et_objets.Exo_41_point_segment;

public class Point
{
    public Point (double x, double y) { this.x = x ; this.y = y ; }
    public void deplace (double dx, double dy) { x += dx ; y += dy ; }
    public void affiche ()
    { System.out.println ("coordonnees = " + x + " " + y ) ;
    }
    private double x, y ;

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
}
