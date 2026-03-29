package heritage_et_polymorphisme;
import java.lang.reflect.Method;
/*
* On souhaite disposer de classes permettant de manipuler des figures géométriques. On
souhaite pouvoir caractériser celles qui possèdent certaines fonctionnalités en leur deman-
dant d’implémenter des interfaces, à savoir :
• Affichable pour celles qui disposeront d’une méthode void affiche (),
• Tranformable pour celles qui disposeront des deux méthodes suivantes :
void homothetie (double coeff)
void rotation (double angle)
Écrire les deux interfaces Affichable et Transformable.*/

public class Exo72_Interface {
    public interface Affichable {
        void affiche();
    }

    public interface Transformable {
        void homothetie(double coeff);
        void rotation(double angle);
    }
}
