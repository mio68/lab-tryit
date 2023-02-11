package mio68.lab.tryit.codewars;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class FibonacciTest {

    @Test
    public void testFib0() {
        testFib(0, 0);
    }

    @Test
    public void testFib1() {
        testFib(1, 1);
    }

    @Test
    public void testFibMinus1() {
        testFib(1, -1);
    }

    @Test
    public void testFibMinus2() {
        testFib(-1, -2);
    }

    @Test
    public void testFib3() {
        testFib(2, 3);
    }

    @Test
    public void testFib4() {
        testFib(3, 4);
    }

    @Test
    public void testFib5() {
        testFib(5, 5);
    }

    @Test
    public void testFib2000000() {
        // Fibonacci 2_000_000 is 417975 digits length
        BigInteger fib = Fibonacci.fib(BigInteger.valueOf(2_000_000));
        assertEquals(417975, fib.toString().length(), "Fib(2_000_000) length is wrong");
    }

    private static void testFib(long expected, long input) {
        BigInteger found;
        try {
            found = Fibonacci.fib(BigInteger.valueOf(input));
        }
        catch (Throwable e) {
            // see https://github.com/Codewars/codewars.com/issues/21
            throw new AssertionError("exception during test: "+e, e);
        }
        assertEquals(BigInteger.valueOf(expected), found);
    }

}