package mio68.lab.tryit.collections;

import mio68.lab.tryit.model.StarWarsCharacter;
import mio68.lab.tryit.model.StarWarsCharacters;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseOrder {

    public static void main(String[] args) {
        List<String> characters = StarWarsCharacters
                .getList()
                .stream()
                .filter(character -> character.getName() != null)
                .map(StarWarsCharacter::getName)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Star Wars characters names -------");
        System.out.println(characters);

        Collections.reverse(characters);
        System.out.println("Characters names in reverse order ---------------");
        System.out.println(characters);
    }

}
