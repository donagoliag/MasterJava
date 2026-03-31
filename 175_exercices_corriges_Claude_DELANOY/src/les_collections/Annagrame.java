package les_collections;

import java.util.*;

public class Annagrame {
    //programme qui prend deux mots et vérifie s’ils sont des anagrammes
    public static int compteure (String mot, char lettre){
        int compteur=0;
        for (int i = 0; i < mot.length(); i++) {
            if (mot.charAt(i) == lettre) {
                compteur++;
            }
        }
        return compteur;
    }


    public static boolean anagramme2mot (String mot1, String mot2){
        String mot1_propre = mot1.toLowerCase().replace(" ", "");
        String mot2_propre = mot2.toLowerCase().replace(" ", "");
        int longueurmot1= mot1_propre.length();
        int longeurmot2=mot2_propre.length();
        boolean anagramme = false;
        int j=longeurmot2-1;

        if (longueurmot1==longeurmot2){
          for (int i =0;i<longeurmot2;i++){
              if (compteure (mot1_propre,mot1_propre.charAt(i)) == compteure (mot2_propre,mot1_propre.charAt(i))){
                  anagramme=true;
              } else anagramme=false;

              if (anagramme==false){
                  break;
              }

          }


        }

        return anagramme;
    }

    //Version 2 - On va utiliser un tableau trie.
    public static boolean estAnagrammetri (String mot1, String mot2) {

        String m1 = mot1.toLowerCase().replace(" ", "");
        String m2 = mot2.toLowerCase().replace(" ", "");

        if (m1.length() != m2.length()) {
            return false;
        }

        String[] tab1 = m1.split("");
        String[] tab2 = m2.split("");

        Arrays.sort(tab1);
        Arrays.sort(tab2);

        return (Arrays.equals(tab1,tab2));

    }

    //Version3 - Utilisons les list

    public static boolean estAnagrammelist(String mot1, String mot2){
        String m1 = mot1.toLowerCase().replace(" ","");
        String m2 = mot2.toLowerCase().replace(" ","");

        if (m1.length() != m2.length()) {
            return false;
        }

        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();

        for (int i = 0; i<m1.length();i++){
            list1.add(m1.charAt(i));
        }

        for (int i = 0; i<m2.length();i++){
            list2.add(m2.charAt(i));
        }

        list1.sort(null);
        list2.sort(null);

        return list1.equals(list2);
    }

    //Version Map
    public static boolean estAnagrammeMap(String mot1, String mot2){
        String m1 = mot1.toLowerCase().replace(" ","");
        String m2 = mot2.toLowerCase().replace(" ","");

        if (m1.length() != m2.length()) {
            return false;
        }

        Map<Character,Integer> mapmot1 = new HashMap<>();
        Map<Character,Integer> mapmot2 = new HashMap<>();

        for (int i = 0; i<m1.length();i++){
            mapmot1.put(m1.charAt(i),compteure(m1,m1.charAt(i)));
        }


        for (int i = 0; i<m2.length();i++){
            mapmot2.put(m2.charAt(i),compteure(m2,m2.charAt(i)));
        }

        return (mapmot2.equals(mapmot1));
    }

    // Recommandation GPT - Utiliser les HashMap

    public static boolean estannagrammeMapv2(String mot1, String mot2){
        String m1 = mot1.toLowerCase().replace(" ","");
        String m2 = mot2.toLowerCase().replace(" ","");

        if (m1.length() != m2.length()) {
            return false;
        }

        Map<Character,Integer> map = new HashMap<>();

        for (int i=0; i<m1.length(); i++){
            map.put(m1.charAt(i),map.getOrDefault(m1.charAt(i),0)+1);
        }

        for (int i=0;i<m2.length();i++){
            if (!map.containsKey(m2.charAt(i))){
                return false;
            }
            map.put(m2.charAt(i),map.get(m2.charAt(i))-1);


            if(map.get(m2.charAt(i))==0){
                map.remove(m2.charAt(i));
            }
        }

        return map.isEmpty();
    }




    public static void main(String[] args){
        System.out.print(estannagrammeMapv2("chien", "niche"));
    }
}
