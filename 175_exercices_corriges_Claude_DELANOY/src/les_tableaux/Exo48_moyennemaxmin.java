package les_tableaux;

/*Écrire un programme qui :
• lit dans un tableau 5 valeurs flottantes fournies au claviera,
• en calcule et en affiche la moyenne, la plus grande et la plus petite valeur.*/

import java.util.Scanner;

public class Exo48_moyennemaxmin {

    public static float moyenne(float[] tab){
       float somme = 0;

       for (int i =0; i < tab.length;i++){
           somme+=tab[i];
       }

       return somme/tab.length;
    }

    public static float max(float[] tab){
        float max = tab[0];

        for (int i =1; i < tab.length;i++){
            if (tab[i]>max){
                max = tab[i];
            }
        }
        return max;
    }

    public static float min(float[] tab){
        float min = tab[0];

        for (int i =1; i < tab.length;i++){
            if (tab[i]<min){
                min = tab[i];
            }
        }
        return min;
    }

    public static void moy_min_max(){

        float[] tab = new float[5];
        for (int i=0;i<5;i++){
            Scanner val = new Scanner(System.in);
            System.out.println("valeur du tableua num _ " + (i+1));
            float valeur = val.nextFloat();
            tab[i]=valeur;
        }

        System.out.println("Votre tableau au complet : ");

        for (int i=0;i<5;i++){
            System.out.println(tab[i]);
        }
        System.out.println("moyenne du tableau : " + moyenne(tab) + " _max : " + max(tab) + " _min : " + min(tab) );
    }

    public static void main(String[] args){
        moy_min_max();
    }
}
