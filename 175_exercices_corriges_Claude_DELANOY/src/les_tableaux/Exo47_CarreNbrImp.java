package les_tableaux;

import java.util.Scanner;

/*Écrire un programme qui crée un tableau comportant les valeurs des carrés des n premiers
nombres impairs, la valeur de n étant lue au claviera et qui en affiche les valeurs sous la
forme suivante :
combien de valeurs : 5
1 a pour carre 1
3 a pour carre 9
5 a pour carre 25
7 a pour carre 49
9 a pour carre 81*/

public class Exo47_CarreNbrImp {

    public static boolean impair(int x){
        return x%2 != 0;
    }

    public static void afficheImpaire(int x){
        int[] stockimpair = new int[x];
        int compteur = 0;
        int j=0;
        while (compteur<x){
            if (impair(j)){
                stockimpair[compteur]=j*j;
                compteur++;
            }
            j++;
        }

        for (int k = 0; k<stockimpair.length; k++){
            System.out.println((Math.sqrt(stockimpair[k])+" a pour carre " + stockimpair[k]));
        }

    }



    public static void main(String[] args){
        Scanner nombre = new Scanner(System.in);
        System.out.println("combien de valeurs : ");
        int n = nombre.nextInt();

        afficheImpaire(n);
    }
}
