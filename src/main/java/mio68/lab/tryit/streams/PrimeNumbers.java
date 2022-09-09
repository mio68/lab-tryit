package mio68.lab.tryit.streams;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class PrimeNumbers {


    public static void main(String[] args) {
        int end = 11;

        System.out.println("primes and non-primes:\n" +
                IntStream.rangeClosed(2, end)
                        .boxed()
                        .collect(Collectors.partitioningBy(PrimeNumbers::isPrime))
        );

    }

    public static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }
}
