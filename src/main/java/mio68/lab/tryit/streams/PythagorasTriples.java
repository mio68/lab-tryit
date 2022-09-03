package mio68.lab.tryit.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static mio68.lab.tryit.streams.Lcd.lcd;

public class PythagorasTriples {

    public static void main(String[] args) {
        getByMaxHypotenuse(100).forEach(t -> System.out.println(Arrays.toString(t)));
    }

    public static List<int[]> getByMaxHypotenuse(int maxHypotenuse) {
        return IntStream.range(1, maxHypotenuse)
                .boxed()
                .flatMap(b -> IntStream.rangeClosed(1, b)
                        .filter(a -> isIntegerHypotenuse(a, b))
                        .mapToObj(a -> new int[]{a, b, (int) hypotenuse(a, b)}))
                .filter(PythagorasTriples::isPrimitive)
                .filter(t -> t[2] <= maxHypotenuse)
                .sorted(Comparator.comparingInt((int[] t) -> t[2])) // sort by hypotenuse
                .collect(Collectors.toList());
    }

    public static boolean isPrimitive(int[] triple) {
        return lcd(lcd(triple[0], triple[1]), lcd(triple[1], triple[2])) == 1;
    }

    public static boolean isIntegerHypotenuse(int catA, int catB) {
        return hypotenuse(catA, catB) % 1 == 0;
    }

    public static double hypotenuse(int catA, int catB) {
        return Math.sqrt(catA * catA + catB * catB);
    }
}
