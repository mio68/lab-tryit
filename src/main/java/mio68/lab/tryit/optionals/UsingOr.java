package mio68.lab.tryit.optionals;

import java.util.Optional;

public class UsingOr {

    public static void main(String[] args) {

        printValueFromFirstNonEmpty(
                Optional.of("one"),
                Optional.of("two"),
                Optional.of("three"));

        printValueFromFirstNonEmpty(
                Optional.empty(),
                Optional.of("two"),
                Optional.of("three"));

        printValueFromFirstNonEmpty(
                Optional.empty(),
                Optional.empty(),
                Optional.of("three"));

        printValueFromFirstNonEmpty(
                Optional.empty(),
                Optional.empty(),
                Optional.empty());


    }

    private static void printValueFromFirstNonEmpty(
            Optional<String> stringOptionalA,
            Optional<String> stringOptionalB,
            Optional<String> stringOptionalC) {

        System.out.println(
                stringOptionalA
                        .or(() -> stringOptionalB)
                        .or(() -> stringOptionalC)
                        .orElse("N/A")
        );
    }

}
