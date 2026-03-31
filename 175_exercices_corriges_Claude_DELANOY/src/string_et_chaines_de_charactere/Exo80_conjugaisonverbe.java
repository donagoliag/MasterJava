package string_et_chaines_de_charactere;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        //Gestion des verbes en eter et en eler qui prenne des accent grave a la conjugaison
        List<String> eteler = new ArrayList<>(Arrays.asList("agneler", "celer", "déceler", "receler", "ciseler",
                "démanteler", "écarteler", "encasteler", "geler", "dégeler", "congeler", "surgeler",
                "marteler", "modeler", "peler", "acheter", "racheter", "bégueter",
                "corseter", "crocheter", "fileter", "fureter", "haleter"));

        String radical;

        if (eteler.contains(verbe)){
            String base = verbe.substring(0, verbe.length() - 2);
            int pos = base.length() - 2;
            radical = base.substring(0, pos) + "è" + base.substring(pos + 1);
        } else {
            if (verbe.endsWith("eler") || verbe.endsWith("eter")){
                char adoubler = verbe.charAt(verbe.length()-2);
                radical = verbe.substring(0,verbe.length()-2) + adoubler + "";
            } else {radical = verbe.substring(0,verbe.length()-2);}

        }


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


        //gestion des verbes en cer et ger et eler eter
        if (verbe.endsWith("ger")){
            tableaudeconjug[7]="eons";
        }


        //Gestion des verbes qui commencent par une voyelle
        if (radical.startsWith("a") || radical.startsWith("e") || radical.startsWith("i") || radical.startsWith("o")
                || radical.startsWith("u") || radical.startsWith("y")){
            tableaudeconjug[0]="J\'";
        }

        for (int i = 0; i<tableaudeconjug.length; i+=2){
            if (radical.endsWith("c")){
                if (i==6){
                    String radicalnew = radical.substring(0,radical.length()-1) + "ç";
                    System.out.print("" + tableaudeconjug[i] + radicalnew + tableaudeconjug[i+1]);
                    System.out.println();
                    continue;
                }
            }
            System.out.print("" + tableaudeconjug[i] + radical + tableaudeconjug[i+1]);
            System.out.println();
        }
    }

    public static void main(String[] args){

        conjugaison();

    }

}
