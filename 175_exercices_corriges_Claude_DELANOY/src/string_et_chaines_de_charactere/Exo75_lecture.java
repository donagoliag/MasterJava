package string_et_chaines_de_charactere;

import java.util.Scanner;

public class Exo75_lecture {

    public static void lecture (){
        Scanner chain = new Scanner(System.in);
        System.out.println("Entrez la chaine :");
        String chaine = chain.nextLine();

        System.out.println("Lecture sur deux:");
        for (int i=0;i<chaine.length();i++){
            if((i%2) == 0) System.out.print(chaine.charAt(i) + "_");
        }
        System.out.print("\n");
        System.out.println("les premier et dernier caractère:");

        System.out.print(chaine.charAt(0) + " et " + chaine.charAt(chaine.length()-1));

    }

    public static void main(String[] args){
        lecture();
    }
}
