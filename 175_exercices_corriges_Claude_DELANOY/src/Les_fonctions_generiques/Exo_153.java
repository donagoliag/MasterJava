package Les_fonctions_generiques;

class TripletH<T,U,V> {
    private T premier;
    private U second;
    private V troisio;

    public TripletH(T premier, U second, V troisio){
        this.premier = premier;
        this.second = second;
        this.troisio = troisio;
    }

    public T getPremier(){
        return this.premier;
    }

    public U getSecond(){
        return this.second;
    }

    public V getTroisio(){
        return this.troisio;
    }


    public void affiche(){
        System.out.println(this.premier + "_" + this.second + "_" + this.troisio);
    }

}

public class Exo_153 {

    public static void main(String[] args){
        String a = "Papa";
        Integer b = 7;
        Boolean c = true;

        TripletH<String,Integer,Boolean> tripl = new TripletH<>(a,b,c);
        tripl.affiche();
    }


}
