package mio68.lab.tryit.concurrency;

import java.util.stream.LongStream;

/**
 * Calculate sum of integer from 1 to N
 */
public class SequenceSum {

    public static long iterativeSum(long n) {
        long sum = 0;
        for (long i = 1L; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(0L, Long::sum);
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
    }

}
