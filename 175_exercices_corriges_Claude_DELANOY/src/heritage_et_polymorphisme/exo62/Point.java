package heritage_et_polymorphisme.exo62;

public class Point {
    public Point (int x, int y) { this.x = x ; this.y = y ; }
    public void affCoord()
    { System.out.println ("Coordonnees : " + x + " " + y) ;
    }
    private int x, y ;
}
