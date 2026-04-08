package Les_fonctions_generiques;
/**Ecrire une méthode générique déterminant le plus grand élément d’un tableau, la compa-
 raison des éléments utilisant l’ordre induit par la méthode compareTo de la classe des
 éléments du tableau.*/


public class Exo_160 {

    public static <T extends Comparable<T>> T comparer(T[] tab) {

        if (tab == null || tab.length == 0) {
            throw new IllegalArgumentException("Le tableau ne doit pas être vide");
        }

        T max = tab[0];

        for (int i = 1; i < tab.length; i++) {
            if (tab[i].compareTo(max) > 0) {
                max = tab[i];
            }
        }

        return max;
    }

    // Petit test
    public static void main(String[] args) {
        Integer[] nombres = {5, 12, 3, 20, 7};
        String[] mots = {"pomme", "banane", "cerise"};

        System.out.println("Max nombres : " + comparer(nombres));
        System.out.println("Max mots : " + comparer(mots));
    }
}