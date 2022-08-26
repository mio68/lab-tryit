package mio68.lab.tryit.arrays;

import java.util.Arrays;

public class Arrayss {

    public static void main(String[] args) {
        Integer[] integers = new Integer[1];
        Object[] objects = integers; // it's ok because arrays are covariant
//        objects[0] = "Try to put a string into array of integers!"; // ArrayStoreException at runtime!

        Long[] longs = new Long[10];
        // Compilation error - incompatible types: java.lang.Object[] cannot be converted to java.lang.Long[]
//        longs = objects;


        String[] strings = new String[3];
        System.out.println("array of strings is initialized: " + Arrays.toString(strings));

        int[] ints = new int[3];
        System.out.println("array of int initialized: " + Arrays.toString(ints));

        boolean[] booleans = new boolean[3];
        System.out.println("array of booleans is initialized: " + Arrays.toString(booleans));


    }
}
