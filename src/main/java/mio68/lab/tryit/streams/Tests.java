package mio68.lab.tryit.streams;

import java.util.stream.Stream;

public class Tests {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3);
        Stream<Integer> multiplied = stream.map(val -> val * 2);
        Stream<Integer> filtered = stream.filter(val -> val % 2 == 1); // throws Exception in
        // thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
        multiplied.forEach(System.out::println);
        filtered.forEach(System.out::println);
    }
}
