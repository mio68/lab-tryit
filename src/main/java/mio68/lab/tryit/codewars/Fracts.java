package mio68.lab.tryit.codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Fracts {
    // your code
    public static String convertFrac(long[][] lst) {
        long[][] reducedFractions = reduce(lst);
        long[] denominators = Arrays.stream(reducedFractions).mapToLong(r -> r[1]).toArray();
        long commonDenom = nok(denominators); System.out.println("common denom = " + commonDenom);
        //set common denominator
        for (long[] fract : reducedFractions ) {
            fract[0] = fract[0] * commonDenom / fract[1];
            fract[1] = commonDenom;
        }

        return Arrays.stream(reducedFractions).map(fract -> Arrays.toString(fract)
                .replaceAll("\\[","(").replaceAll("\\]",")").replaceAll(" ",""))
                .collect(Collectors.joining());
    }

    public static long nok(long... nums) {
        long [] distinctNums = Arrays.stream(nums).distinct().toArray();
        long res = prod(distinctNums);
        long d = nod(distinctNums);
        for (int i = 0; i < distinctNums.length; i++)
            res /= d;
        return res;
    }

    public static long prod(long... nums) {
        long prod = 1;
        for (long num: nums ) prod *= num;
        return prod;
    }

    public static long[][] reduce(long[][] ar) {
        long [][] res = new long[ar.length][];
        for(int i = 0; i < ar.length; i++)
            res[i] = reduce(ar[i]);
        return res;
    }

    public static long[] reduce(long [] r) {
        long d = nod(r);
        return new long[]{r[0]/d, r[1]/d};
    }

    public static long nod(long... nums) {
        long d = nums[0];
        for (int i = 1; i < nums.length; i++)
            d = nod(d, nums[i]);
        return d;
    }

    public static long nod(long i, long j) {
        if(i < j) { long t = i; i = j; j = t;}

        long r;
        while ((r = i % j) != 0) { i = j; j = r; }

        return j;
    }
}
