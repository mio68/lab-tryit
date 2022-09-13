package mio68.lab.tryit.optionals;

import java.util.Optional;

public class MapReturnsNull {

    public static void main(String[] args) {
        Optional<String> stringOptional = Optional.of("Hi there!");

        System.out.println(
                stringOptional.map(s -> (String) null)
                        .orElse("Mapped to empty optional!")
        );
    }
}
