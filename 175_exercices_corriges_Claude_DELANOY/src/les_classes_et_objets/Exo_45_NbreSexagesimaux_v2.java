package les_classes_et_objets;

/*
On souhaite disposer d’une classe permettant d’effectuer des conversions (dans les deux
sens) entre nombre sexagésimaux (durée exprimée en heures, minutes, secondes) et des
nombres décimaux (durée exprimée en heures décimales). Pour ce faire, on réalisera une
classe permettant de représenter une durée. Elle comportera :
• un constructeur recevant trois arguments de type int représentant une valeurs sexagé-
simale (heures, minutes, secondes) qu’on supposera normalisée (secondes et minutes
entre 0 et 59). Aucune limitation ne portera sur les heures ;
• un constructeur recevant un argument de type double représentant une durée en
heures ;
• une méthode getDec fournissant la valeur en heures décimales associée à l’objet,
• des méthodes getH, getM et getS fournissant les trois composantes du nombre sexa-
gésimal associé à l’objet.
On proposera deux solutions :
1. Avec un champ (privé) représentant la valeur décimale,
2. Avec des champs (privés) représentant la valeur sexagésimale.
*/

public class Exo_45_NbreSexagesimaux_v2 {

    private double heures;


    public Exo_45_NbreSexagesimaux_v2(int H, int M, int S){
        heures = H + (M/60.0) + (S/3600.0);
    }

    public Exo_45_NbreSexagesimaux_v2(double H){
        heures = H;
    }

    public double getDec(){
        return (heures);
    }

    public int getH(){
        return (int)heures;
    }


    public int getM(){
        double reste = heures - (int)heures;
        return (int)(reste * 60);
    }

    public int getS(){
        double reste = heures - (int)heures;
        double minutes = reste * 60;
        double secondes = (minutes - (int)minutes) * 60;
        return (int)secondes;
    }

    public static void main(String[] args){

        // 🔹 Test avec h, m, s
        Exo_45_NbreSexagesimaux_v2 d1 = new Exo_45_NbreSexagesimaux_v2(2, 30, 45);

        System.out.println("=== Test 1 (h, m, s) ===");
        System.out.println("Heures : " + d1.getH());
        System.out.println("Minutes : " + d1.getM());
        System.out.println("Secondes : " + d1.getS());
        System.out.println("Decimal : " + d1.getDec());

        // 🔹 Test avec décimal
        Exo_45_NbreSexagesimaux_v2 d2 = new Exo_45_NbreSexagesimaux_v2(3.75);

        System.out.println("\n=== Test 2 (decimal) ===");
        System.out.println("Heures : " + d2.getH());
        System.out.println("Minutes : " + d2.getM());
        System.out.println("Secondes : " + d2.getS());
        System.out.println("Decimal : " + d2.getDec());
    }
}
