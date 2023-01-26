package mio68.lab.tryit.streams;

import java.util.stream.IntStream;

public class Ints {

    public static void main(String[] args) {
        // Stream is empty
        IntStream.rangeClosed(1, 1).forEach(System.out::println);
    }

}
