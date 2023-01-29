package mio68.lab.tryit.collections;

import java.util.HashMap;
import java.util.Map;

public class MapIdioms {

    public static void main(String[] args) {
        Map<String, Integer> moviesUnmodifieble = Map.of(
                "James Bond", 20,
                "Matrix", 15,
                "Harry Potter", 5);
        Map<String, Integer> movies = new HashMap<>(moviesUnmodifieble);

        // Remove some entries by predicate
        movies.entrySet()
                .removeIf(entry -> entry.getValue() < 10);
        System.out.println("Remove entries that match predicate: " + movies);

        // Merge
        movies.merge("James Bond", 1, (oldVal, newVal) -> oldVal + 1);
        movies.merge("Harry Potter", 1, (oldVal, newVal) -> oldVal + 1);
        System.out.println("Merged: " + movies);
    }

}
