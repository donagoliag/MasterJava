package les_classes_et_objets;

import java.util.HashMap;
import java.util.Map;

/*
Réaliser une classe qui permet d’attribuer un numéro unique à chaque nouvel objet créé
(1 au premier, 2 au suivant...). On ne cherchera pas à réutiliser les numéros d’objets éven-
tuellement détruits. On dotera la classe uniquement d’un constructeur, d’une méthode getI-
dent fournissant le numéro attribué à l’objet et d’une méthode getIdentMax fournissant le
numéro du dernier objet créé.
*/

public class Exo_31_AttributionNum {

    private String NomPersonne;
    private static int Numeroprochain =1 ;
    private int Numero ;

    public  Exo_31_AttributionNum(String NomPersonne){
        this.NomPersonne = NomPersonne;
        this.Numero = Numeroprochain;
        Numeroprochain ++;
    }


    public int getIdent (){
        return this.Numero;
    }

    public int getIdentMax (){
        return (Numeroprochain-1);
    }

    public String Affiche(){
        return (this.NomPersonne + ", Personne Num " + this.getIdent() + " Creee. IdentMax = " + this.getIdentMax());
    }

    public static void main(String[] args){
        Exo_31_AttributionNum Priscille = new Exo_31_AttributionNum("Priscille");
        System.out.println(Priscille.Affiche());
        Exo_31_AttributionNum Gerard = new Exo_31_AttributionNum("Gerard");
        System.out.println(Gerard.Affiche());
        Exo_31_AttributionNum Johan = new Exo_31_AttributionNum("Johan");
        System.out.println(Johan.Affiche());
    }

}
