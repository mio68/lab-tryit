package mio68.lab.tryit.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Tests {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3);
        Stream<Integer> multiplied = stream.map(val -> val * 2);
        // thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
        //Stream<Integer> filtered = stream.filter(val -> val % 2 == 1); // throws Exception in
//        multiplied.forEach(System.out::println);
//        filtered.forEach(System.out::println);

        // Question 45
        int reduce = IntStream.of(0, 1, 2)
                .map(i -> i + 1)
                .reduce(1, (a, s) -> a + s);

        System.out.println(reduce);

    }
}
