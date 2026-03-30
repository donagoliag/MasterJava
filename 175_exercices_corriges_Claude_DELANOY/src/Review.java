public class Review {
    public static void main(String[] args){
        // Comparaison de chaînes (String)
        String s1 = "Apple";
        String s2 = "Banan";
        int result = s1.compareTo(s2); // Retourne un nombre négatif car A < B
        System.out.println(result);

// Comparaison de nombres (Integer)
        Integer n1 = 5;
        Integer n2 = 5;
        boolean resultNum = n1.equals(n2); // Retourne 1 (positif) car 10 > 5
        System.out.println(resultNum);
    }
}
