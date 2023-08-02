package mio68.lab.tryit.puzzlers;

public class Puzzle3LongDivision {

    public static void main(String[] args) {
        long us = 24 * 60 * 60 * 1000 * 1000; // Exact value is 86_400_000_000 but
        // literals are integers so result is integer. Max value of integer is
        // 2^31-1 = 2_147_483_647  anf overflow occures!
        System.out.println(us); // prints wrong result 500654080
        long ms = 24 * 60 * 60 * 1000; // prints right result 86400000
        System.out.println(ms);
        System.out.println(us / ms); // prints 5

        long us2 = 24 * 60 * 60 * 1000 * 1000L; // Just one L symbol solves the problem!
        System.out.println(us2); // 86400000000 correct!
        System.out.println(us2 / ms); // 1000 - correct!
    }

}
