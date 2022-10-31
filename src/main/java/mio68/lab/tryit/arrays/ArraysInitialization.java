package mio68.lab.tryit.arrays;

import java.util.Arrays;

public class ArraysInitialization {

    public static void main(String[] args) {

        Object[] objects = new String[3];
        System.out.println("array of objects is initialized: " + Arrays.toString(objects));

        String[] strings = new String[3];
        System.out.println("array of strings is initialized: " + Arrays.toString(strings));

        int[] ints = new int[3];
        System.out.println("array of int is initialized: " + Arrays.toString(ints));

        boolean[] booleans = new boolean[3];
        System.out.println("array of booleans is initialized: " + Arrays.toString(booleans));

    }
}
