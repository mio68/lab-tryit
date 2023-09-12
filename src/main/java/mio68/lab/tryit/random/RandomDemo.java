package mio68.lab.tryit.random;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class RandomDemo {

    public static final int SEED = 1000;

    public static void main(String[] args) {
        Random rnd = new Random(SEED);
        Random rnd2 = new Random(SEED);

        byte[] bytes = new byte[16];
        byte[] bytes2 = new byte[16];

        rnd.nextBytes(bytes);
        System.out.println(Arrays.toString(bytes));
        rnd2.nextBytes(bytes2);
        System.out.println(Arrays.toString(bytes2));
        System.out.println(Arrays.equals(bytes, bytes2));



        rnd.nextBytes(bytes);
        System.out.println(Arrays.toString(bytes));
        rnd2.nextBytes(bytes2);
        System.out.println(Arrays.toString(bytes2));
        System.out.println(Arrays.equals(bytes, bytes2));


        // reproduce pseudo-random sequence
        byte[] initial = new byte[1024];
        rnd.setSeed(SEED);
        rnd.nextBytes(initial);

        byte[] next = new byte[1024];
        rnd.setSeed(SEED);
        rnd.nextBytes(next);
        System.out.println(Arrays.equals(initial, next)); // true


        rnd.setSeed(SEED);
        rnd.nextBytes(next);
        System.out.println(Arrays.equals(initial, next)); // true

        rnd.setSeed(SEED);
        rnd.nextBytes(next);
        System.out.println(Arrays.equals(initial, next)); // true

    }

}
