package mio68.lab.tryit.streams;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteStreams {

    public static void main(String[] args) {
        System.out.println(
                "Sequence of 2^n " +
                        Stream.iterate(1, n -> n * 2)
                                .limit(17) // don't forget to limit infinite stream!
//                                .takeWhile(integer -> integer <= 65536) // another way to limit the stream
                                .map(String::valueOf)
                                .collect(Collectors.joining(", ")));

        System.out.println(
                "Fibonacci numbers: " +
                        Stream.iterate(new int[]{0, 1}, p -> new int[]{p[1], p[0] + p[1]})
                                .map(p -> p[0])
                                .limit(10)
                                .map(String::valueOf)
                                .collect(Collectors.joining(", ")));

        System.out.println(
                "Dice " +
                        IntStream.generate(() -> ThreadLocalRandom.current().nextInt(1, 7))
                                .mapToObj(String::valueOf)
                                .limit(10)
                                .collect(Collectors.joining(", ")));

        // with anonymous class for IntSupplier
        System.out.println(
                "Fibonacci numbers again: " +
                        IntStream.generate(new IntSupplier() {
                                    private int cur = 0;
                                    private int next = 1;

                                    @Override
                                    public int getAsInt() {
                                        int tmp = cur;
                                        cur = next;
                                        next += tmp;
                                        return tmp;
                                    }
                                })
                                .limit(10)
                                .mapToObj(String::valueOf)
                                .collect(Collectors.joining(", ")));
    }

}
