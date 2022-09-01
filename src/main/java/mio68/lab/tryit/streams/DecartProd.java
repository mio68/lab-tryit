package mio68.lab.tryit.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class DecartProd {

    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .flatMap(i -> Stream.of(3,4)
                        .map(j -> new int[]{i,j}))
                .filter(ints -> (ints[0] + ints[1]) % 3 == 0)
                .map(Arrays::toString)
                .forEach(System.out::println);
    }
}
