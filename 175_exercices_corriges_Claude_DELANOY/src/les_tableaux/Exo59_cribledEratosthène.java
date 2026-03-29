package les_tableaux;

import java.util.Scanner;

/*Il existe une méthode de détermination de tous les nombres premiers compris entre 1 et n,
connue sous le nom de "crible d’Eratosthène". Elle consiste à dresser une liste de tous les
nombres entiers considérés et à y "rayer" tous les multiples d’autres entiers. Plus précisé-
ment, on procéde ainsi :
• on raye le 1 (qui, par définition, n’est pas un nombre premier),
• on recherche, à partir du dernier nombre premier considéré (la première fois, on convient
qu’il s’agit du 1), le premier nombre non rayé (on peut montrer qu’il est premier). Il
devient, à son tour, le dernier nombre premier considéré et on raye tous ses multiples.

On répète le traitement précédent jusqu’à ce que le nombre premier considéré soit
supérieur à la racine carrée de n. On peut alors démontrer que tous les nombres non
premiers ont été rayés de la liste.
Écrire un programme exploitant cette méthode pour rechercher tous les nombres premiers
compris entre 1 et une valeur fournie en donnée.
*/
public class Exo59_cribledEratosthène {
    public void premier (int n) {
        boolean[] prem = new boolean[n+1];
        prem[0] = false;
        prem[1]=false;
        for (int i = 2; i <= n; i++) {
            prem[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {

            if (prem[i]) {  

                for (int j = i*i; j <= n; j+=i) {
                        prem[j] = false;
                }

            }
        }

        for (int i = 0; i < prem.length; i++) {
            if (prem[i]) {
                System.out.print(i + " , ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entrez un nombre n : ");
        int n = sc.nextInt();

        Exo59_cribledEratosthène crible = new Exo59_cribledEratosthène();
        System.out.println("Nombres premiers jusqu'à " + n + " :");
        crible.premier(n);
    }
}
