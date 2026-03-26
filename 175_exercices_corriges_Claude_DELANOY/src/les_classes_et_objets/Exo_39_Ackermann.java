package les_classes_et_objets;

/*Écrire une méthode statique d’une classe statique Util calculant la valeur de la "fonction
d’Ackermann" A définie pour m>=0 et n>=0 par :
        • A (m, n) = A (m-1, A(m, n-1)) pour m>0 et n>0,
        • A (0, n) = n+1 pour n>0,
        • A (m, 0) = A(m-1, 1) pour m>0.*/

public class Exo_39_Ackermann {

    public static int Ackerman (int n, int m){

        if (n==0) { return  m+1; }
        if (m==0) { return Ackerman(n-1,1);}
        return Ackerman(n-1,Ackerman(n,m-1));

    }

    public static void main(String[] args){
        System.out.println(Ackerman(3,3));
    }

}
