package mio68.lab.tryit.streams;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Joining {

    public static void main(String[] args) {
        String s = Stream.of("Hello", "World!")
                .collect(Collectors.joining(" "));

        System.out.println(s);

        s = Arrays.stream(new String[]{})
                .collect(Collectors.joining());

        System.out.println(String.format("empty stream of String joining returns: [%s]",s));
    }
}
