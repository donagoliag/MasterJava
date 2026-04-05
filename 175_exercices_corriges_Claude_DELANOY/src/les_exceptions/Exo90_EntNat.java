package les_exceptions;

import java.util.Scanner;


/*Réaliser une classe EntNat permettant de manipuler des entiers naturels (positifs ou nuls).
Pour l’instant, cette classe disposera simplement :
• d’un constructeur à un argument de type int qui générera une exception de type
ErrConst (type classe à définir) lorsque la valeur reçue ne conviendra pas,
• d’une méthode getN fournissant sous forme d’un int, la valeur encapsulée dans un objet
de type EntNat.
Écrire un petit programme d’utilisation qui traite l’exception ErrConst en affichant un mes-
sage et en interrompant l’exécution*/
class ErrConst extends Exception {
    public ErrConst(String message) {
        super(message);
    }
}

public class Exo90_EntNat {

    private int n;

    public Exo90_EntNat(int n) throws ErrConst{

        if(n<0){
            throw new ErrConst("Valeur negative interdite !");
        }
        this.n=n;
    }

    public int getN(){

        return this.n;

    }

    public static void main(String[] args){

        try {

            Scanner s = new Scanner(System.in);
            System.out.print("Nombre : ");
            int n = s.nextInt();
            Exo90_EntNat entier = new Exo90_EntNat(n);
            System.out.print("Valeur = " + entier.getN());
        }catch (ErrConst e){
            System.out.println("Erreur : " + e.getMessage());
            System.exit(-1);
        }

    }

}
