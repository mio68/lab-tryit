package mio68.lab.tryit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountElements {

    public static <T> Map<T, Long> countFrquencyOfElements(List<T> list) {
        return list.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
    }

    private final static Map<Integer, String> intToWordTranslator = new HashMap<>();
    static {
        intToWordTranslator.put(1, "one");
        intToWordTranslator.put(2, "two");
        intToWordTranslator.put(3, "three");
    }


    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,2,3,1,2,2,1,3,2,3);
        List<String> stringList = integerList.stream()
                .map(i -> intToWordTranslator.get(i))
                        .collect(Collectors.toList());

        System.out.println(countFrquencyOfElements(integerList));
        System.out.println(countFrquencyOfElements(stringList));
    }
}
