package Les_fonctions_generiques;

class Triplet<T> {
    private T premier;
    private T second;
    private T troisio;

    public Triplet(T premier, T second, T troisio){
       this.premier = premier;
       this.second = second;
       this.troisio = troisio;
    }

    public T getPremier(){
        return this.premier;
    }

    public T getSecond(){
        return this.second;
    }

    public T getTroisio(){
        return this.troisio;
    }


    public void affiche(){
        System.out.println(this.premier + "_" + this.second + "_" + this.troisio);
    }

}

public class Exo_152_Triplet {
    public static void main(String[] args){
        String a = "Jamais";
        String b = "Pamais";
        String c = "Vamais";

        Triplet<String> oui = new Triplet<>(a,b,c);

        oui.affiche();
    }
}
