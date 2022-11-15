package mio68.lab.tryit.streams;

import mio68.lab.tryit.model.Index;
import mio68.lab.tryit.model.Instance;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingWithCollectorsChain {

    public static void main(String[] args) {
        List<Instance> instances = Arrays.asList(
                new Instance("indexA", null),
                new Instance("indexB", "primary"),
                new Instance("indexС", null),
                new Instance("indexB", "secondary"),
                new Instance("indexE", "primary"));


        instances.stream()
                .collect(
                        Collectors.groupingBy(
                                Instance::getIndexName,
                                LinkedHashMap::new, // To preserve original order
                                Collectors.mapping(
                                        Index::new,
                                        Collectors.reducing(Index::merge)
                                )
                        )
                ).values()
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

}
