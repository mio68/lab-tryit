package mio68.lab.tryit;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.math.BigInteger.*;

public class PrimeNumbersStream {

    public static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }

    public static void main(String[] args) {
        Stream<BigInteger> primes = primes();
        final int limit = 50;

        List<BigInteger> primesList =
        primes
                .limit(limit)
                .collect(Collectors.toList());

//        System.out.println(primesList);

        // Get stream from collection
        String s = primesList.stream()
                .map(BigInteger::toString)
                .collect(Collectors.joining(", ",
                        "This is first " + limit + " prime numbers from stream from collection: [",
                        "]"));
        System.out.println(s);


        // Get iterator from collection
        System.out.print("Iterate prime stream collection: [");
        Iterator<BigInteger> bigIntegerIterator = primesList.iterator();
        while (bigIntegerIterator.hasNext()) {
            BigInteger next =  bigIntegerIterator.next();
            System.out.print(next + (bigIntegerIterator.hasNext() ? ", " : ""));
        }
        System.out.println("]");

    }
}
