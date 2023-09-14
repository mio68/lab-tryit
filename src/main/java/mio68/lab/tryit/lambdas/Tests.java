package mio68.lab.tryit.lambdas;

import java.util.function.Consumer;

public class Tests {
    public static void main(String[] args) {
        Consumer<String> consumer;

//        consumer = () -> System.out.println("Hello!"); // invalid
        consumer = s -> System.out.println(s);
        consumer = (s) -> System.out.println(s);
        consumer = System.out::println;

    }
}
