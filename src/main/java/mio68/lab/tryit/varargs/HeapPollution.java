package mio68.lab.tryit.varargs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @link https://www.baeldung.com/java-varargs
 * @link https://en.wikipedia.org/wiki/Heap_pollution
 */
public class HeapPollution {

    static String firstOfFirst(List<String>... strings) {
        List<Integer> ints = Collections.singletonList(42);
        Object[] objects = strings;
        objects[0] = ints; // Heap pollution

        return strings[0].get(0); // ClassCastException
    }

    public static void main(String[] args) {
        firstOfFirst(
                Arrays.asList("one", "two"),
                Arrays.asList("three", "four", "five"));
    }

}
