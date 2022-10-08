package mio68.lab.tryit.lambdas;

import java.util.Arrays;

public class MethReferences {

    public static void main(String[] args) {
        Integer[] integers = {3, 5, 1, 10, 4, 2};

        Integer[] copy = Arrays.copyOf(integers, integers.length);
        Arrays.sort(copy, Integer::compare);
        System.out.println("Sorted with static method reference.");
        System.out.println(Arrays.toString(copy));

        copy = Arrays.copyOf(integers, integers.length);
        Arrays.sort(copy, Integer::compareTo);
        System.out.println("Sorted with arbitrary object method reference.");
        System.out.println(Arrays.toString(copy));

    }

}
