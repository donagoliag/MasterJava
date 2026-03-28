package les_tableaux;

/*Réaliser une classe nommée Aleat permettant de disposer de suites de nombres entiers
aléatoires. On y prévoira les méthodes suivantes
• constructeur Aleat (int n, int lim), n représentant le nombre de valeurs souhaitées,
appartenant à l’intervalle [0, lim] ;
getValeur (int n) qui fournit la valeur de rang n de la suite ;
• getValeurs () qui fournit un tableau contenant toutes les valeurs de la suite,
• histo() qui fournit un histogramme des valeurs de la suite, c’est-à-dire un tableau de
lim+1 valeurs dans lequel un élément de rang i représente le nombre de fois où la
valeur i est présente dans la suite.
Écrire un petit programme d’utilisation.*/

import java.util.Random;

public class Exo56_Aleat {
    private int[] nbreval;
    private int limite;


    public Exo56_Aleat(int n, int lim){
        nbreval = new int[n];
        Random r = new Random();
        for (int i =0; i<nbreval.length;i++){
            nbreval[i]= r.nextInt(lim+1);
        }

        limite =lim;
    }

    public int getValeur(int n){
        return nbreval[n-1];
    }

    public int[] getValeurs(){
        return nbreval;
    }

    public static int compteaaparition(int[] tab, int n){
        int compteur =0;
        for (int i=0; i<tab.length ; i++){
            if (n==tab[i]){
                compteur+=1;
            }
        }
        return compteur;
    }

    public int[] histo(){
        int[] tab = new int[limite + 1];

        for (int i=0; i<=limite;i++){
            tab[i] = compteaaparition(nbreval,i);
        }
        return tab;
    }

    /*deuxiem proposition sans imp compter apparition:
    public int[] histo(){
    int[] tab = new int[limite + 1];
    for (int v : nbreval){
        tab[v]++;
    }
    return tab;
}
*/

    public static void main(String[] args){
        Exo56_Aleat suite = new Exo56_Aleat(10, 5);

        System.out.println("Toutes les valeurs :");
        for(int v : suite.getValeurs()){
            System.out.print(v + " ");
        }
        System.out.println("\nValeur d'indice 3 : " + suite.getValeur(3));

        System.out.println("Histogramme :");
        int[] hist = suite.histo();
        for(int i=0;i<hist.length;i++){
            System.out.println(i + " : " + hist[i]);
        }
    }
}
