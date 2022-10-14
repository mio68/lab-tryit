package mio68.lab.tryit.streams;

import mio68.lab.tryit.model.Texts;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortingMap {

    public static void main(String[] args) {
        String preprocessedText = Texts.THE_WALRUS_AND_THE_CARPENTER
                .replaceAll("[^a-zA-Z’]", " ")
                .toLowerCase();


        Map<String, Long> wordFreq = Arrays.stream(preprocessedText.split(" "))
                .map(String::trim)
                .filter(s -> s.length() > 1)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        // Comparator for map entries. Sort by values with reverse order, then sort by keys.
        Comparator<Map.Entry<String, Long>> comparator = Comparator.comparing(Map.Entry<String, Long>::getValue)
                .reversed()
                .thenComparing(Map.Entry::getKey);

        // Map ordering. Key moment is to travers entry set.
        Map<String, Long> sortedWordFreq =
        wordFreq.entrySet()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (l1, l2) -> l1,
                        LinkedHashMap::new
                ));

        sortedWordFreq.forEach((key, value) -> System.out.println(key + "=" + value));
    }

}
