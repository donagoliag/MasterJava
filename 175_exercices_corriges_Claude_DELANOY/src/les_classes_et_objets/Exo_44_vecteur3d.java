package les_classes_et_objets;
/*
Réaliser une classe Vecteur3d permettant de manipuler des vecteurs à trois composantes
(de type double) et disposant :
• d’un constructeur à trois arguments,
• d’une méthode d’affichage des coordonnées du vecteur, sous la forme :
< composante_1, composante_2, composante_3 >
d’une méthode fournissant la norme d’un vecteur,
• d’une méthode (statique) fournissant la somme de deux vecteurs,
• d’une méthode (non statique) fournissant le produit scalaire de deux vecteurs.
Écrire un petit programme (main) utilisant cette classe.
*/
public class Exo_44_vecteur3d {
    private double xd;
    private double yd;
    private double zd;

    public Exo_44_vecteur3d (double x, double y, double z){
        xd = x;
        yd = y;
        zd = z;
    }

    public String affiche3d(){
        return ("< " + xd + " , " + yd + " , "+ zd + " >");
    }
    //Apprend a calculer norm de vecteur
    public double normevecteur (){
        return Math.sqrt(xd*xd + yd*yd + zd*zd);
    }

    public static Exo_44_vecteur3d sommevecteur (Exo_44_vecteur3d A,Exo_44_vecteur3d B){
       return (new Exo_44_vecteur3d(A.xd+ B.xd, A.yd+ B.yd, A.zd+ B.zd));
    }

    public double produitScalaire (Exo_44_vecteur3d A,Exo_44_vecteur3d B){
        return Math.sqrt(A.xd* B.xd + A.yd* B.yd + A.zd* B.zd);
    }

}
