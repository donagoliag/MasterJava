package les_classes_et_objets;

/*
Adapter la classe précédente, de manière que le numéro initial des objets soit lu au cla-
viera . On devra s’assurer que la réponse de l’utilisateur est strictement positive.
*/
//Ici j'ai appris a utiliser scanner et mieux pris conscience de methode static avec getIdentMax
import java.util.Scanner;

public class Exo_32_AttributionNum {

    private String NomPersonne;
    private static int Numeroprochain;
    private int Numero ;

    public static void affecterPremiereNum(){
        Scanner numproch = new Scanner(System.in);
        do{
            System.out.println("Entrez le numero du premier Objet, il doit etre positif");
            Exo_32_AttributionNum.Numeroprochain = numproch.nextInt();

        }while (Numeroprochain<=0);

    }

    public  Exo_32_AttributionNum(String NomPersonne){
        this.NomPersonne = NomPersonne;
        this.Numero = Exo_32_AttributionNum.Numeroprochain;
        Exo_32_AttributionNum.Numeroprochain ++;
    }

    public int getIdent (){
        return this.Numero;
    }

    public static int getIdentMax (){
        return (Numeroprochain-1);
    }

    public String Affiche(){
        return (this.NomPersonne + ", Personne Num " + this.getIdent() + " Creee. IdentMax = " + getIdentMax());
    }

    public static void main(String[] args){
        affecterPremiereNum();
        Exo_32_AttributionNum Priscille = new Exo_32_AttributionNum("Priscille");
        System.out.println(Priscille.Affiche());
        Exo_32_AttributionNum Gerard = new Exo_32_AttributionNum("Gerard");
        System.out.println(Gerard.Affiche());
        Exo_32_AttributionNum Johan = new Exo_32_AttributionNum("Johan");
        System.out.println(Johan.Affiche());
    }

}
