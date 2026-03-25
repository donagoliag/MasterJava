package les_classes_et_objets;

public class Exo_23_Point {
    private char nom;
    private double abcisse;

    public Exo_23_Point(char nom, double abcisse){
        this.nom = nom;
        this.abcisse=abcisse;
    }

    public char getNom(){
        return this.nom;
    }

    public void setNom(char nom){
        this.nom = nom;
    }

    public double getAbcisse(){
        return this.abcisse;
    }

    public void setAbcisse(double abcisse) {
        this.abcisse = abcisse;
    }

    public String affiche(){
        return ("Nom du point : " + this.nom + " Nom de l'abciss : " + this.abcisse);
    }

    public void translation(double newAbcisse){
        this.abcisse = newAbcisse;
    }

    public static void main(String[] args){
        //Creation de Points

        Exo_23_Point point_A = new Exo_23_Point('A',5);

        //Test Afficher
        System.out.println("Avant translation : " + point_A.affiche());

        //Test translation
        point_A.translation(10);
        System.out.println("Apres translation : " + point_A.affiche());

    }
}
