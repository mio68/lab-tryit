package mio68.lab.tryit.streams;

import mio68.lab.tryit.model.StarWarsCharacter;
import mio68.lab.tryit.model.StarWarsCharacters;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;
import static mio68.lab.tryit.model.StarWarsCharacter.Kind.JEDI;
import static mio68.lab.tryit.model.StarWarsCharacter.Kind.SITH;

public class Grouping {

    public static void main(String[] args) {
        List<StarWarsCharacter> list = StarWarsCharacters.getList();

        System.out.println("One level grouping by homeworld ------------");
        System.out.println(list.stream()
                .collect(groupingBy(
                        ch -> ch.getHomeworld() == null ? "N/A" : ch.getHomeworld().toString(),
                        mapping(StarWarsCharacter::getName, toList()))));

        System.out.println("One level grouping  by homeworld and counting------------");
        System.out.println(list.stream()
                .collect(groupingBy(
                        ch -> ch.getHomeworld() == null ? "N/A" : ch.getHomeworld().toString(),
                        counting())));

        System.out.println("One level grouping  by homeworld and find character with max weight------------");
        System.out.println(list.stream()
                .collect(groupingBy(
                        ch -> ch.getHomeworld() == null ? "N/A" : ch.getHomeworld().toString(),
                        // Use collectingAndThen to apply final processing to collecting result
                        // Here we get payload from Optional returned by maxBy.
                        collectingAndThen(
                            maxBy(comparing(StarWarsCharacter::getMassInKg, nullsFirst(Integer::compareTo))),
                            och -> och.map(StarWarsCharacter::getName).orElse("no characters")))));

        System.out.println("One level grouping  by homeworld and find JEDI with max weight------------");
        System.out.println(list.stream()
                .collect(groupingBy(
                        ch -> ch.getHomeworld() == null ? "N/A" : ch.getHomeworld().toString(),
                        collectingAndThen(
                            filtering(
                                ch -> ch.getKind() == JEDI,
                                maxBy(comparing(StarWarsCharacter::getMassInKg, nullsFirst(Integer::compareTo)))
                            ),
                            och -> och.map(StarWarsCharacter::getName).orElse("no characters")))));

        System.out.println("Two level grouping by homeworld then by kind ------------");
        System.out.println(list.stream()
                .collect(Collectors.groupingBy(
                        ch -> ch.getHomeworld() == null ? "N/A" : ch.getHomeworld().toString(),
                        Collectors.groupingBy(
                                ch -> ch.getKind() == null ? "N/A" : ch.getKind().toString(),
                                Collectors.mapping(StarWarsCharacter::getName, Collectors.toList())))));

    }

}
