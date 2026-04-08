package Les_fonctions_generiques;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*Écrire une méthode qui renvoie au hasard un objet choisi parmi deux objets de même type
fournis en argument. Écrire un petit programme utilisant cette méthode.*/

public class Exo_157 {

    public static <T> T renvoie(T a, T b){
        Random random = new Random();
        int chiffre = random.nextInt(2);

        if(chiffre == 0){
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {

        System.out.println(renvoie("Chef", "Patron"));
        System.out.println(renvoie(10, 20));
        System.out.println(renvoie(true, false));
    }

}
