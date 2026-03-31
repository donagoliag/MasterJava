package string_et_chaines_de_charactere;

/*Écrire un programme qui lit une suite de mots au claviera et qui les affiche triés par ordre
alphabétique. On supposera que ces mots ne contiennent que des lettres non accentuées
(majuscules ou minuscules). Le nombre de mots sera fourni en données et l’exécution se
présentera ainsi :
Combien de mots ? 5
donnez vos mots
javaScript
Pascal
BaSiC
Java
ADA
Liste par ordre alphabetique :
ADA
BaSiC
Java
javaScript
Pascal
Notez bien que les mots sont affichés avec leur "casse" d’origine mais que celle-ci n’influe
pas sur le tri qui respecte l’ordre alphabétique traditionnel (qui ne distingue pas les majus-
cules des minuscules)*/

import java.util.*;

public class Exo81_TrideMots {

    //Avec les fonction de arraylist
   public static void tri(){
       System.out.print("Combien de mots: ");
       Scanner s = new Scanner(System.in);
       int nbre_mots = s.nextInt();
       s.nextLine();

       System.out.println("Donnez vos mots: ");
       List<String> listMot = new ArrayList<>();

       for (int i = 0; i<nbre_mots;i++){
           System.out.print("Mot " + (i+1)  +" : ");
           String mot = s.nextLine();
           listMot.add(mot);
           System.out.println();
       }

       Collections.sort(listMot, String.CASE_INSENSITIVE_ORDER);
       for (int i=0; i<nbre_mots;i++){
           System.out.println(listMot.get(i));
       }
   }

   //Comparaison implementer
    public static List<String> compare(){
        System.out.print("Combien de mots: ");
        Scanner s = new Scanner(System.in);
        int nbre_mots = s.nextInt();
        s.nextLine();

        System.out.println("Donnez vos mots: ");
        List<String> listMot = new ArrayList<>();

        for (int i = 0; i<nbre_mots;i++){
            System.out.print("Mot " + (i+1)  +" : ");
            String mot = s.nextLine();
            listMot.add(mot);
            System.out.println();
        }

        String temp;

        for (int i=0; i<listMot.size()-1;i++){
            for(int j=i+1;j<listMot.size();j++){
                if (listMot.get(j).compareToIgnoreCase(listMot.get(i))<0){
                    temp=listMot.get(i);
                    listMot.set(i,listMot.get(j));
                    listMot.set(j,temp);
                }
            }
        }

        return listMot;
    }

   public static void main(String[] args){

       //tri();

       System.out.println(compare());
   }

}
