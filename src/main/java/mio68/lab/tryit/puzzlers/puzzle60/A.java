package mio68.lab.tryit.puzzlers.puzzle60;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class A {

    public static <E> List<E> removeDuplicates(List<E> list) {
        return new ArrayList<>(new LinkedHashSet<>(list));
    }

    public static <E> List<E> removeDuplicates2(List<E> list) {
        return list.stream().sequential().distinct().collect(Collectors.toList());
    }

}
