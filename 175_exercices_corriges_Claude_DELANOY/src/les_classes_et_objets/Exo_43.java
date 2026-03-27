package les_classes_et_objets;

/* Modifier la classe Point réalisée dans l’exercice 42, de manière que les données (privées)
soient maintenant les coordonnées polaires d’un point et non plus ses coordonnées carté-
siennes. On fera en sorte que le "contrat" initial de la classe soit respecté en évitant de
modifier les champs publics ou les en-têtes de méthodes publiques (l’utilisation de la
classe devra continuer à se faire de la même manière). */

public class Exo_43 {

    public  Exo_43 (double x, double y) { this.rho = Math.sqrt(x*x + y*y) ; this.theta = Math.atan2(y,x); }
    public void deplace (double dx, double dy) {
        double x=rho*Math.cos(theta);
        double y=rho*Math.sin(theta);

        x += dx ; y += dy ;

        this.rho = Math.sqrt(x*x + y*y);
        this.theta = Math.atan2(y,x);
    }

    public double abscisse () {

        return rho*Math.cos(theta) ; }

    public double ordonnee () {
        return rho*Math.sin(theta) ; }

    private double rho ; // abscisse
    private double theta ; // ordonnee

    //homothetie qui multiplie les coordonnées par une valeur (de type double) fournie en argument
    public void homothetie (double multiplicateur){
        double x=rho*Math.cos(theta);
        double y=rho*Math.sin(theta);

        x *= multiplicateur ; y *= multiplicateur ;

        this.rho = Math.sqrt(x*x + y*y);
        this.theta = Math.atan2(y,x);
    }

    //rotation qui effectue une rotation dont l’angle est fourni en argument
    public void rotation (double angledeg){
        double angleradian = Math.toRadians(angledeg);
        double x=rho*Math.cos(theta);
        double y=rho*Math.sin(theta);


        double rotx = x*Math.cos(angleradian) - y*Math.sin(angleradian);
        double roty = y*Math.cos(angleradian) + x*Math.sin(angleradian);

        this.rho = Math.sqrt(rotx*rotx + roty*roty);
        this.theta = Math.atan2(roty,rotx);
    }

    //rho et theta qui fournissent les coordonnées polaires du point,
    public double polx(){
        return rho;
    }

    public double poly(){
        return theta;
    }

    //afficheCart qui affiche les coordonnées cartésiennes du point,
    public String afficheCart (){
        return ("abcisse_ "+ this.abscisse() + "_ordonnee_"+ this.ordonnee());
    }

    // affichePol qui affiche les coordonnées polaires du point.
    public String pol (){
        return ("abcissepolaire_ "+ rho + "_ordonneepolaire_"+ theta);
    }

    public static void main(String[] args){
        Exo_43 pointA = new Exo_43(15,7);

        System.out.println("Avant Homotetie");
        System.out.println(pointA.afficheCart());
        System.out.println(pointA.pol());

        System.out.println("Apres Homotetie");
        pointA.homothetie(2);
        System.out.println(pointA.afficheCart());
        System.out.println(pointA.pol());

        System.out.println("Apres rotation");
        pointA.rotation(30);
        System.out.println(pointA.afficheCart());
        System.out.println(pointA.pol());

    }

}
