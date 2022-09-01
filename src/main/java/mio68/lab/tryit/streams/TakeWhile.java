package mio68.lab.tryit.streams;

import java.util.stream.Stream;

public class TakeWhile {

    public static void main(String[] args) {

        System.out.println("Take while------");
        Stream.of(1,2,3,4,5,1,2,3,4)
                .takeWhile(i -> i < 5)
                .forEach(System.out::println);

        System.out.println("Drop while------");
        Stream.of(1,2,3,4,5,1,2,3,4)
                .dropWhile(i -> i < 5)
                .forEach(System.out::println);

    }

}
