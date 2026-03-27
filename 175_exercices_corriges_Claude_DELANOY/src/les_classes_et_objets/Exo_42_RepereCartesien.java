package les_classes_et_objets;

/* Soit la classe Point ainsi définie :
class Point
{ public Point (double x, double y) { this.x = x ; this.y = y ; }
public void deplace (double dx, double dy) { x += dx ; y += dy ; }
public double abscisse () { return x ; }
public double ordonnee () { return y ; }
private double x ; // abscisse
private double y ; // ordonnee
}
La compléter en la dotant des méthodes suivantes :
• homothetie qui multiplie les coordonnées par une valeur (de type double) fournie en
argument,
• rotation qui effectue une rotation dont l’angle est fourni en argument,
• rho et theta qui fournissent les coordonnées polaires du point,
• afficheCart qui affiche les coordonnées cartésiennes du point,
• affichePol qui affiche les coordonnées polaires du point */

public class Exo_42_RepereCartesien {

    public  Exo_42_RepereCartesien (double x, double y) { this.x = x ; this.y = y ; }
    public void deplace (double dx, double dy) { x += dx ; y += dy ; }
    public double abscisse () { return x ; }
    public double ordonnee () { return y ; }
    private double x ; // abscisse
     private double y ; // ordonnee

    //homothetie qui multiplie les coordonnées par une valeur (de type double) fournie en argument
    public void homothetie (double multiplicateur){
        this.x*=multiplicateur;
        this.y*=multiplicateur;
    }

    //rotation qui effectue une rotation dont l’angle est fourni en argument
    public void rotation (double angledeg){
        double angleradian = Math.toRadians(angledeg);

        double radx = this.x;
        double rady = this.y;

        this.x = radx*Math.cos(angleradian) - rady*Math.sin(angleradian);
        this.y = rady*Math.cos(angleradian) + radx*Math.sin(angleradian);

    }

    //• rho et theta qui fournissent les coordonnées polaires du point,
    public double rho(){
        return Math.sqrt(x*x +y*y);
    }

    public double theta(){
        return Math.atan2(this.y,this.x);
    }

    //afficheCart qui affiche les coordonnées cartésiennes du point,
    public String afficheCart (){
        return ("abcisse_ "+ x + "_ordonnee_"+ y);
    }

    // affichePol qui affiche les coordonnées polaires du point.
    public String affichepol (){
        return ("abcissepolaire_ "+ this.rho() + "_ordonneepolaire_"+ this.theta());
    }

    public static void main(String[] args){
        Exo_42_RepereCartesien pointA = new Exo_42_RepereCartesien(15,7);

        System.out.println("Avant Homotetie");
        System.out.println(pointA.afficheCart());
        System.out.println(pointA.affichepol());

        System.out.println("Apres Homotetie");
        pointA.homothetie(2);
        System.out.println(pointA.afficheCart());
        System.out.println(pointA.affichepol());

        System.out.println("Apres rotation");
        pointA.rotation(30);
        System.out.println(pointA.afficheCart());
        System.out.println(pointA.affichepol());

    }

}
