package mio68.lab.tryit.collections;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {

    public static void main(String[] args) {
        Set<Integer> setA = Set.of(1, 2, 3, 4, 5);
        Set<Integer> setB = Set.of(2, 4);

        Set<Integer> diff = difference(setA, setB);
        System.out.println(diff);

        Set<Integer> diff2 = difference(setB, setA);
        System.out.println(diff2);
    }


    static <T> Set<T> difference(final Set<T> setA, final Set<T> setB) {
        Set<T> copyOfSetA = new HashSet<>(setA);
        copyOfSetA.removeAll(setB);
        return copyOfSetA;
    }

}
