package heritage_et_polymorphisme;

/*On souhaite disposer d’une hiérarchie de classes permettant de manipuler des figures
géométriques. On veut qu’il soit toujours possible d’étendre la hiérarchie en dérivant de
nouvelles classes mais on souhaite pouvoir imposer que ces dernières disposent toujours
des méthodes suivantes :
• void affiche ()
• void homothetie (double coeff)
• void rotation (double angle)
Écrire la classe abstraite Figure qui pourra servir de classe de base à toutes ces classes.

Compléter la classe abstraite Figure de l’exercice précédent, de façon qu’elle implémente :
• une méthode homoRot (double coef, double angle) qui applique à la fois une homo-
thétie et une rotation à la figure,
• de méthodes statiques afficheFigures, homothetieFigures et rotationFigures appliquant
une même opération (affichage, homothétie ou rotation) à un tableau de figures (objets
d’une classe dérivée de Figure).*/

public abstract class Exo70et71_figGeo {
    public abstract void affiche ();
    public abstract void homothetie (double coeff);
    public abstract void rotation (double angle);

    public void homoRot (double coef, double angle){
        this.homothetie(coef);
        this.rotation(angle);
    }

    public static void afficheFigures(Exo70et71_figGeo[] figures){
        for (Exo70et71_figGeo f:figures){
            f.affiche();
        }
    }

    public static void homothetieFigures(Exo70et71_figGeo[] figures, double coef){
        for (Exo70et71_figGeo f:figures){
            f.homothetie(coef);
        }
    }

    public static void rotationFigures(Exo70et71_figGeo[] figures, double angle){
        for (Exo70et71_figGeo f:figures){
            f.rotation(angle);
        }
    }

}
