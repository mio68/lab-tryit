package mio68.lab.tryit.optionals;

import java.util.Optional;

public class TwoOptionals {

    public static void main(String[] args) {

        // Prints Hello from optionalA!
        tryToGetFromOptionalsSequently(Optional.of("optionalA"), Optional.of("optionalB"));

        // Prints Hi from optionalB!
        tryToGetFromOptionalsSequently(Optional.empty(), Optional.of("optionalB"));

        // Prints Hi there!
        tryToGetFromOptionalsSequently(Optional.empty(), Optional.empty());


    }

    private static void tryToGetFromOptionalsSequently(
            Optional<String> stringOptionalA,
            Optional<String> stringOptionalB) {

        System.out.println(
                stringOptionalA.map(s -> "Hello from " + s + "!")
                        .orElse( stringOptionalB.map(s -> "Hi from " + s + "!")
                                .orElse("Hi there!"))
        );
    }


}
