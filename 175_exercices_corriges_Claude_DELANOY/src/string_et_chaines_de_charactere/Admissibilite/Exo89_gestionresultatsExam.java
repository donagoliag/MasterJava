package string_et_chaines_de_charactere.Admissibilite;
/*
* On se propose d’établir les résultats d’examen d’un ensemble d’élèves. Chaque élève sera
représenté par un objet de type Eleve, comportant obligatoirement les champs suivants :
• le nom de l’élève (type String),
• son admissibilité à l’examen, sous forme d’une valeur d’un type énuméré comportant les
valeurs suivantes : N (non admis), P (passable), AB ( Assez bien), B (Bien), TB (Très bien).
Idéalement, les noms des élèves pourraient être contenus dans un fichier. Ici, par souci de
simplicité, nous les supposerons fournis par un tableau de chaînes placé dans le programme
principal.
On demande de définir convenablement la classe Eleve et d’écrire un programme principal qui :
• pour chaque élève, lit au clavier 3 notes d’examen, en calcule la moyenne et renseigne
convenablement le champ d’admissibilité, suivant les règles usuelles :
– moyenne < 10 : Non admis
– 10 <= moyenne <12 : Passable
– 12 <= moyenne <14 : Assez bien
– 14 <= moyenne <16 : Bien
– 16 <= moyenne : Très bien
• affiche l’ensemble des résultats en fournissant en clair la mention obtenue.
Voici un exemple d’exécution d’un tel programme :
donnez les trois notes de l'eleve Dutronc
11.5
14.5
10
donnez les trois notes de l'eleve Dunoyer
9.5
10.5
9
donnez les trois notes de l'eleve Lechene
14.5
12
16.5
donnez les trois notes de l'eleve Dubois
6
14
11
donnez les trois notes de l'eleve Frenet
17.5
14
18.5
* Resultats :
Dutronc - Assez bien
Dunoyer - Non admis
Lechene - Bien
Dubois - Passable
Frenet - Tres bien*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exo89_gestionresultatsExam {
    private String nom;
    private ADMISSIBILITE admissibilite;


   public Exo89_gestionresultatsExam (String noms){
       this.nom = noms;
       Scanner s = new Scanner(System.in);
       double totalnote = 0;
       System.out.println("Donnez les 3 Note de l'eleve " + noms + " : ");
       for (int i=0;i<3;i++){
           System.out.print("Note " + (i+1) + " : ");
           totalnote += s.nextDouble();
           System.out.println();
       }

       double moyenne = totalnote/3;

       if (moyenne < 10){
           this.admissibilite= ADMISSIBILITE.NON_ADMIS;
       } else if ((10 <= moyenne) &&(moyenne<12)) {
           this.admissibilite = ADMISSIBILITE.PASSABLE;
       } else if ((12 <= moyenne) &&(moyenne<14)) {
           this.admissibilite = ADMISSIBILITE.ASSEZ_BIEN;
       }else if ((14 <= moyenne) &&(moyenne<16)) {
           this.admissibilite = ADMISSIBILITE.BIEN;
       }  else this.admissibilite=ADMISSIBILITE.TRES_BIEN;

   }

   public void affiche(){
       System.out.println(this.nom+ " - " + this.admissibilite);
   }

   public static void main(String[] args) {
       String[] noms = {"Samira","Romel","Caty"};
       List<Exo89_gestionresultatsExam> listnom = new ArrayList<>();

       for (String v: noms){
           Exo89_gestionresultatsExam eleve = new Exo89_gestionresultatsExam(v);
           listnom.add(eleve);
       }

       System.out.println("===========RESULTATS===============");
       for (Exo89_gestionresultatsExam v: listnom){
           v.affiche();
       }
   }
}

/*Correction GPT
*package string_et_chaines_de_charactere;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Enum
enum ADMISSIBILITE {
    NON_ADMIS, PASSABLE, ASSEZ_BIEN, BIEN, TRES_BIEN
}

// Classe Eleve
class Eleve {
    private String nom;
    private ADMISSIBILITE admissibilite;

    // Constructeur SIMPLE (sans Scanner)
    public Eleve(String nom, double moyenne) {
        this.nom = nom;
        this.admissibilite = calculMention(moyenne);
    }

    // Méthode pour déterminer la mention
    private ADMISSIBILITE calculMention(double moyenne) {
        if (moyenne < 10) return ADMISSIBILITE.NON_ADMIS;
        else if (moyenne < 12) return ADMISSIBILITE.PASSABLE;
        else if (moyenne < 14) return ADMISSIBILITE.ASSEZ_BIEN;
        else if (moyenne < 16) return ADMISSIBILITE.BIEN;
        else return ADMISSIBILITE.TRES_BIEN;
    }

    // Affichage propre
    public void affiche() {
        System.out.println(nom + " - " + formatMention());
    }

    // Pour afficher joli (pas en MAJUSCULE)
    private String formatMention() {
        switch (admissibilite) {
            case NON_ADMIS: return "Non admis";
            case PASSABLE: return "Passable";
            case ASSEZ_BIEN: return "Assez bien";
            case BIEN: return "Bien";
            case TRES_BIEN: return "Très bien";
            default: return "";
        }
    }
}

// Classe principale
public class Exo89_gestionresultatsExam {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String[] noms = {"Samira", "Romel", "Caty"};
        List<Eleve> eleves = new ArrayList<>();

        for (String nom : noms) {
            System.out.println("Donnez les 3 notes de l'élève " + nom + " :");

            double total = 0;

            for (int i = 0; i < 3; i++) {
                System.out.print("Note " + (i + 1) + " : ");
                total += s.nextDouble();
            }

            double moyenne = total / 3;

            // Création propre de l'objet
            Eleve e = new Eleve(nom, moyenne);
            eleves.add(e);
        }

        System.out.println("\n=========== RESULTATS ===========");

        for (Eleve e : eleves) {
            e.affiche();
        }

        s.close();
    }
}
* */


