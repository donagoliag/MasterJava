import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class Review {
    public static void main(String[] args) {
        List<Integer> nombre = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        Function<Integer, Integer> carre = (x) -> {
            return x * x;
        };
        nombre.replaceAll(x->x*x );
    }
}
