package string_et_chaines_de_charactere;

import java.util.Scanner;

public class Exo76_Entierenchaine {
    public static void entierenchaine(){
        Scanner s = new Scanner(System.in);
        System.out.println("Entrez la chaine :");
        int entier = s.nextInt();
        String entierchaine = Integer.toString(entier);

        for (int i =0; i<entierchaine.length();i++){
            System.out.println(""+entierchaine.charAt(i));
        }
    }

    public static void main(String[] args){
        entierenchaine();
    }
}