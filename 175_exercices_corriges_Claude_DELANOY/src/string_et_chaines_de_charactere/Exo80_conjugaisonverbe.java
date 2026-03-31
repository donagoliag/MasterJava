package string_et_chaines_de_charactere;

import java.util.Scanner;

public class Exo80_conjugaisonverbe {

    public static void conjugaison(){
        Scanner s = new Scanner(System.in);
        System.out.print("Donnez un verbe regulier du premier groupe : ");
        String verb = s.nextLine();
        String verbe = verb.toLowerCase();
        s.close();


        if (verbe.equalsIgnoreCase("aller") || (!verbe.endsWith("er"))){
            System.out.println("Ce verbe nest pas du premier groupe, reprenez avec un verbe du premier groupe.");
            System.exit(0);
        }

        if (verbe.endsWith("ger") || verbe.endsWith("cer") || verbe.endsWith("ller") || verbe.endsWith("tter") || verbe.endsWith("eter") || verbe.endsWith("eler") ){
            System.out.println("Verbe du premier groupe non accepte, reprenez avec un autre verbe du premier groupe.");
            System.exit(0);
        }

        String conjug = verbe.substring(0,verbe.length()-2);

        String[] tableaudeconjug = new String[12];
        tableaudeconjug[0]="Je ";
        tableaudeconjug[1]="e.";
        tableaudeconjug[2]="Tu ";
        tableaudeconjug[3]="es.";
        tableaudeconjug[4]="Il ou elle ";
        tableaudeconjug[5]="e.";
        tableaudeconjug[6]="Nous ";
        tableaudeconjug[7]="ons.";
        tableaudeconjug[8]="Vous ";
        tableaudeconjug[9]="ez.";
        tableaudeconjug[10]="Ils ou Elles ";
        tableaudeconjug[11]="ent";

        for (int i = 0; i<tableaudeconjug.length; i+=2){
            System.out.print("" + tableaudeconjug[i] + conjug + tableaudeconjug[i+1]);
            System.out.println();
        }
    }

    public static void main(String[] args){

        conjugaison();

    }

}
