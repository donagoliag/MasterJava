package les_tableaux;
/*Réaliser une classe utilitaire concernant des tableaux de tableaux de valeurs de type
double et contenant les méthodes statiques suivantes :
• affiche (double t [ ] [ ]) : affiche les valeurs de t, à raison d’une ligne d’écran pour une
ligne du tableau,
• boolean regulier (double t [ ] [ ]) : teste si le tableau t est régulier, c’est-à-dire si toutes
ses lignes ont la même taille,
• double [ ] sommeLignes (double t [ ] [ ]) : fournit un tableau de double correspondant
aux sommes des différentes lignes de t,
• double [ ] [ ] somme (double [ ] [ ] t1, double [ ] [ ] t2) : s’assure que les tableaux t1 et t2
sont réguliers et de mêmes dimensions et fournit dans ce cas leur somme en résultat ;
dans le cas contraire, elle fournit une référence nulle.
Écrire un petit programme de test.
}*/
public class Exo58_matrice {

    public void affiche (double[][] t ){

        for (int lign = 0; lign<t.length;lign++){
            for (int col =0; col<t[lign].length; col++){
                System.out.print(t[lign][col]+ " ");
            }
            System.out.println();
        }
    }

    public static boolean regulier (double t [] []){
        int taille_ligne = t[0].length;

        for (int ligne=0; ligne<t.length; ligne++){
            if (t[ligne].length !=taille_ligne){
                return false;
            }
        }
        return true;
    }

    public double [] sommeLignes (double t [][]){
        double [] somme = new double[(t.length)];

        int col =0;

        for (int i = 0; i < t.length; i++){
            for (int j = 0; j < t[i].length; j++){
                somme[i] += t[i][j];
            }
        }
        return somme;
    }

    public double [ ] [ ] somme (double [ ] [ ] t1, double [ ] [ ] t2) {
        double[][] somme = new double[t1.length][t1[0].length];
       if (regulier(t1)&&regulier(t2)) {
           if ((t1.length==t2.length)&&(t1[0].length==t2[0].length)){


               for (int lign = 0; lign<t1.length;lign++){
                   for (int col =0; col<t1[lign].length; col++){
                       somme[lign][col]=t1[lign][col]+t2[lign][col];
                   }
               }

               return somme;
           }

       }

       return null;
    }

    public static void main(String[] args){

        double[][] t1 = {
                {1, 2, 3},
                {4, 5, 6}
        };

        double[][] t2 = {
                {10, 20, 30},
                {40, 50, 60}
        };

        // Création d'un objet (car tes méthodes ne sont pas toutes static)
        Exo58_matrice m = new Exo58_matrice();

        // Affichage des matrices
        System.out.println("Matrice t1 :");
        m.affiche(t1);

        System.out.println("Matrice t2 :");
        m.affiche(t2);

        // Test regulier
        System.out.println("t1 est régulier ? " + Exo58_matrice.regulier(t1));

        // Somme des lignes
        double[] sommes = m.sommeLignes(t1);
        System.out.println("Somme des lignes de t1 :");
        for (double s : sommes){
            System.out.print(s + " ");
        }
        System.out.println();

        // Somme des matrices
        double[][] res = m.somme(t1, t2);

        System.out.println("Somme t1 + t2 :");
        if (res != null){
            m.affiche(res);
        } else {
            System.out.println("Matrices incompatibles");
        }
    }
}
