package mio68.lab.tryit.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class Flattening {

    public static void main(String[] args) {
        Stream.of("Hello", "World")
                .map(s -> s.split(""))
//                .flatMap(Stream::of) //variant 1
                .flatMap(Arrays::stream)//variant 2
                .distinct()
                .map(String::toLowerCase)
                .sorted()
                .forEach(System.out::println);
    }
}
