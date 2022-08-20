package mio68.lab.tryit;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountElements {

    public static <T> Map<T, Long> countFrequencyOfElements(List<T> list) {
        return list.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
    }

    // Immutable map
    private final static Map<Integer, String> intToWordTranslator = Map.of(
            1, "one",
            2, "two",
            3, "three"
    );

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,2,3,1,2,2,1,3,2,3);
        List<String> stringList = integerList.stream()
                .map(intToWordTranslator::get)
                .collect(Collectors.toList());

        System.out.println(countFrequencyOfElements(integerList));
        System.out.println(countFrequencyOfElements(stringList));

//        intToWordTranslator.put(4, "four"); // throws UnsupportedOperationException
    }
}
