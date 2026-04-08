package Les_fonctions_generiques;

/*On dispose de la classe générique suivante :
class Couple<T>
{ private T x, y ; // les deux éléments du couple
public Couple (T premier, T second)
{ x = premier ; y = second ;
}
public void affiche ()
{ System.out.println ("premiere valeur : " + x
+ " - deuxieme valeur : " + y ) ;
}
}
1. Créer, par dérivation, un classe CoupleNomme permettant de manipuler des couples
analogues à ceux de la classe Couple<T>, mais possédant, en outre, un nom de type
String. On redéfinira convenablement les méthodes de cette nouvelle classe en réutili-
sant les méthodes de la classe de base.
2. Toujours par dérivation à partir de Couple<T>, créer cette fois une « classe ordinaire »
(c’est-à-dire une classe non générique), nommée PointNomme, dans laquelle les élé-
ments du couple sont de type Integer et le nom, toujours de type String.
3. Écrire un petit programme de test utilisant ces deux classes CoupleNomme et Point-
Nomme.*/
class Couple<T>
{ private T x, y ; // les deux éléments du couple
    public Couple (T premier, T second)
    { x = premier ; y = second ;
    }
    public void affiche ()
    { System.out.println ("premiere valeur : " + x
            + " - deuxieme valeur : " + y ) ;
    }
}


public class Exo_158<T> extends Couple<T> {

    private String nom;

    public Exo_158 (T premier, T second, String name){
        super(premier,second);
        nom=name;
    }

    public void affiche ()
    { System.out.print ("Coordeonnees de " + this.nom + ": ") ;
        super.affiche();
    }
}
