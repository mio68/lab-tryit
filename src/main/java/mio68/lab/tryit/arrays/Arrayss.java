package mio68.lab.tryit.arrays;

public class Arrayss {

    public static void main(String[] args) {
        Integer[] integers = new Integer[1];
        Object[] objects = integers; // it's ok because arrays are covariant
//        objects[0] = "Try to put a string into array of integers!"; // ArrayStoreException at runtime!

        Long[] longs = new Long[1];

        // Compilation error - incompatible types: java.lang.Object[] cannot be converted to java.lang.Long[]
//        longs = objects;

    }
}
