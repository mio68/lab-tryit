package mio68.lab.tryit;

import java.util.List;

public class CustomCollectionsClient {

    public static void main(String[] args) {
        List<Integer> littlePrimes = CustomCollections.getPrimesLessThan10();
        System.out.println("little primes: " + littlePrimes);

        List<Integer> littleFibo = CustomCollections.of(new int[]{1, 1, 2, 3, 5, 8, 13});
        System.out.println("little fibo: " + littleFibo);
//        littleFibo.add(17); // throws lang.UnsupportedOperationException

        // Notice that CustomCollections.MyArrayList is not available here.
        CustomCollections.AnotherArrayList anotherArrayList = new CustomCollections
                .AnotherArrayList(new int[]{1, 2, 6, 10});
        System.out.println("another array list:" + anotherArrayList);

        System.out.println("from custom collections get: " + CustomCollections.of(new int[]{}).getClass().getName());
        System.out.println("from extended custom collections get: " + ExtendedCustomCollections.of(new int[]{}).getClass().getName());

        // Instantiation of utility class for learning purposes
        CustomCollections customCollections = new CustomCollections();
        System.out.println("from custom collections reference get: " + customCollections.of(new int[]{}).getClass().getName());

        // For static members no late binding
        customCollections = new ExtendedCustomCollections();
        System.out.println("from custom collections reference get: " + customCollections.of(new int[]{}).getClass().getName());

    }
}
