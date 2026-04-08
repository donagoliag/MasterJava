package Les_fonctions_generiques;

import java.util.Random;

public class Exo_156 {

    public static  <T> T extrator (T[] tab){

        Random random= new Random();
        int index = random.nextInt(tab.length);

        return tab[index];
    }

    public static void main(String[] args){

        String[] nouveau = {"habib","baruk","chap"};
        Integer[] nbre = {11,4,8,75,6};

        System.out.println(extrator(nouveau));
        System.out.println(extrator(nbre));
    }
}
