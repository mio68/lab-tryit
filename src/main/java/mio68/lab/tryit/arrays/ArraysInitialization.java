package mio68.lab.tryit.arrays;

import java.util.Arrays;
import java.util.logging.SocketHandler;

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

        int[][] checks = new int[3][3];
        System.out.println("check initial state: " + Arrays.deepToString(checks));
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("matrix: " + Arrays.deepToString(matrix));
        int[][] matrix2 = new int[2][];
        System.out.println("matrix2: " + Arrays.deepToString(matrix2));
        int[][] matrix3 = new int[][]{{1,2}, null, {4,5,6,7,8}};
        System.out.println("matrix3: " + Arrays.deepToString(matrix3));

        String[] strings1 = new String[]{"one", "two"};
        String[] strings2 = {"one", "two", "three"};

    }
}
