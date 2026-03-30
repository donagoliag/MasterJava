package string_et_chaines_de_charactere;

public class Exo78_argenligndecom {
    public static void main(String[] args) {

        //Verifie qu'on a deux argument en ligne de commandes
        //Verifier que les argument son des chiffres sans signe + ou moins.

        if ((args.length==2)){
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);


            System.out.println(a + " " + b + " = " + (a+b));

        } else System.exit(-1);

    }
}
