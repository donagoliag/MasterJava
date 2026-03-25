package les_classes_et_objets;

public class Exo_30_manipPoint {

    private static int Origine =0;
    private char Nom;
    private int Abcisse;

    public Exo_30_manipPoint(char Nom, int Abcisse){
        this.Abcisse = Abcisse;
        this.Nom = Nom;
    }

    public String affiche(){
        return ("Le Point " + this.Nom + " a une abcisse de " + (this.Abcisse-Exo_30_manipPoint.Origine) + " Relative a une origine d'abscisse " + Exo_30_manipPoint.Origine);
    }

    public void setOrigine(int newOrigine){
        Exo_30_manipPoint.Origine = newOrigine;
    }

    public String getOrigine(){
        return ("Origine du point " + this.Nom + " : " + Exo_30_manipPoint.Origine);
    }

    public static void main(String[] args){
        Exo_30_manipPoint point_A = new Exo_30_manipPoint('A',-1);
        System.out.println(point_A.affiche());
        System.out.println(point_A.getOrigine());
        point_A.setOrigine(2);
        System.out.println(point_A.getOrigine());
        System.out.println(point_A.affiche());
    }


}
