package mio68.lab.tryit.streams;

import java.util.stream.Stream;

public class StreamOfNullable {

    public static void main(String[] args) {
        Stream.of("USERNAME", "HOME", "USER", "OS")
                .flatMap(s -> Stream.ofNullable(System.getenv(s)))
                .forEach(System.out::println);
    }
}
