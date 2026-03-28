package les_tableaux;

/*
Réaliser une classe Vecteur permettant de manipuler des vecteurs ayant un nombre quel-
conque de composantes de type double. On y prévoira :
• un constructeur Vecteur (int n), n représentant le nombre de composantes qui seront
alors initialisées à zéro,
• un constructeur Vecteur (int n, double x), n représentant le nombre de composantes qui
seront alors toutes initialisées à la valeur x,
• un constructeur Vecteur (double [ ] v) qui créera un vecteur par recopie du tableau v,
• une méthode (non statique) prod_scal fournissant le produit scalaire de deux
vecteurs (ici, si les deux vecteurs ne sont pas de même taille, on se contentera de
fournir la valeur zéro),
• une méthode (statique) somme fournissant la somme de deux vecteurs ; s’ils n’ont pas
la même taille, on renverra une référence "nulle",
• une méthode affiche affichant les composantes d’un vecteur.
Écrire un petit programme d’utilisation.*/
public class Exo57_CalVect {

    private double[] composantes;

    public Exo57_CalVect(int n){
        composantes = new double[n];
    }

    public Exo57_CalVect(int n, double x){
        composantes = new double[n];
        for (double v:composantes){
            v=x;
        }
    }

    public Exo57_CalVect(double[] v){
      composantes = new double[v.length];
        for (int i = 0; i < composantes.length; i++){
            composantes[i] = v[i];
        }
    }

    public double prod_scal(Exo57_CalVect v){
        if (composantes.length != v.composantes.length){
            return 0;
        }

        double scalaire = 0;
        for (int i = 0; i < composantes.length; i++){
            scalaire += composantes[i] * v.composantes[i];
        }
        return scalaire;
    }

    public static Exo57_CalVect somme(Exo57_CalVect v1, Exo57_CalVect v2){
        if (v1.composantes.length != v2.composantes.length){
            return null;
        }

        Exo57_CalVect res = new Exo57_CalVect(v1.composantes.length);

        for (int i = 0; i < v1.composantes.length; i++){
            res.composantes[i] = v1.composantes[i] + v2.composantes[i];
        }

        return res;
    }

    public void affiche(){
        System.out.print("[ ");
        for (int i = 0; i < composantes.length; i++){
            System.out.print(composantes[i] + " ");
        }
        System.out.println("]");
    }



    public static void main(String[] args){
        Exo57_CalVect v1 = new Exo57_CalVect(3, 2.0);
        Exo57_CalVect v2 = new Exo57_CalVect(new double[]{1.0, 2.0, 3.0});

        v1.affiche();
        v2.affiche();

        System.out.println("Produit scalaire : " + v1.prod_scal(v2));

        Exo57_CalVect somme = Exo57_CalVect.somme(v1, v2);
        if (somme != null){
            somme.affiche();
        }
    }
}
