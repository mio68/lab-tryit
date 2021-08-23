package mio68.lab.tryit.codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Fracts {

    public static String convertFrac(long[][] lst) {
        if(lst.length == 0)
            return "";

        long[][] simplifiedFracts = simplify(lst);
        long commonDenom = nok(getDenoms(simplifiedFracts));
        setDenom(simplifiedFracts, commonDenom);
        return fractToString(simplifiedFracts);
    }

    public static long[] getDenoms(long[][] fractions) {
        return Arrays.stream(fractions).mapToLong(r -> r[1]).toArray();
    }

    private static void setDenom(long[][] fractions, long denom) {
        for (long[] fract : fractions )
            setDenom(fract, denom);
    }

    private static void setDenom(long[] fract, long denom) {
        fract[0] = fract[0] * denom / fract[1];
        fract[1] = denom;
    }

    public static String fractToString(long[][] fractions) {
            return Arrays.stream(fractions)
                    .map(Arrays::toString)
                    .collect(Collectors.joining())
                    .replaceAll("\\[","(")
                    .replaceAll("]",")")
                    .replaceAll(" ","");
    }

    public static long nok(long... nums) {
        long nok = nums[0];
        for (int i = 1; i < nums.length; i++)
            nok = nok(nok, nums[i]);
        return nok;
    }

    public static long nok(long i, long j) {
        return i * j / nod(i, j);
    }

    public static long[][] simplify(long[][] ar) {
        long [][] res = new long[ar.length][];
        for(int i = 0; i < ar.length; i++)
            res[i] = simplify(ar[i]);
        return res;
    }

    public static long[] simplify(long [] r) {
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
        //order them
        if(i < j) { long t = i; i = j; j = t;}

        long r;
        while ((r = i % j) != 0) { i = j; j = r; }

        return j;
    }

    public static void printFractions(long[][] fractions) {
        for (long[] fract: fractions )
            System.out.print( Arrays.toString(fract) + ",");
        System.out.println();
    }
}
