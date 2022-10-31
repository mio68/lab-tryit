package mio68.lab.tryit.arrays;

public class ArraysCovariance {

    public static void main(String[] args) {
        Integer[] integers = new Integer[1];

        // It's ok because arrays are covariant -
        // Integer is subtype of Object => Integer[] is subtype of Object[]
        Object[] objects = integers;

        // Compilation: OK
        // String is subtype of Object
        // Runtime: Exception in thread "main" java.lang.ArrayStoreException: java.lang.String
        objects[0] = "Try to put a string into array of integers!";

        Long[] longs = new Long[10];
        // Compilation: Compilation error - incompatible types: java.lang.Object[] cannot be converted to java.lang.Long[]
        //  longs = objects;
    }

}
