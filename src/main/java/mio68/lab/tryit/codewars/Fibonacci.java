package mio68.lab.tryit.codewars;

import java.math.BigInteger;

// Codewars https://www.codewars.com/kata/53d40c1e2f13e331fc000c26/train/java
public class Fibonacci {

    public static BigInteger fib(BigInteger bigN) {
        int n = bigN.intValue();
        BigInteger fib = fib(Math.abs(n));
        if (isNegativeFibNum(n)) {
            fib = fib.negate();
        }
        return fib;
    }

    private static BigInteger fib(int n) {
        return switch (n) {
            case 0 -> BigInteger.ZERO;
            case 1, 2 -> BigInteger.ONE;
            default -> n % 2 == 0 ?
                    fib(n / 2).multiply(fib(n / 2 + 1).add(fib(n / 2 - 1))) :
                    fib((n + 1) / 2).pow(2).add(fib((n + 1) / 2 - 1).pow(2));
        };
    }

    private static boolean isNegativeFibNum(int n) {
        return n < 0 && n % 2 == 0;
    }

}