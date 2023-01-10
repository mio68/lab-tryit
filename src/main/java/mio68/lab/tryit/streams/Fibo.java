package mio68.lab.tryit.streams;

import java.util.List;
import java.util.stream.Stream;

public class Fibo {
    public static void main(String[] args) {
        List<Integer> fiboNumbers = Stream
                .iterate(new int[]{0, 1}, p -> new int[]{p[1], p[0] + p[1]})
                .map(p -> p[0])
                .limit(20)
                .toList();

        System.out.println(fiboNumbers);
    }
}
