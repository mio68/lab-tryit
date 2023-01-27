package mio68.lab.tryit.codewars;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

public class SnailTest {

    @Test
    public void SnailTest3() {
        int[][] array
                = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[] r = {1, 2, 3, 6, 9, 8, 7, 4, 5};
        test(array, r);
    }

    @Test
    public void SnailTest4() {
        int[][] array
                = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[] r = {1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10};
        test(array, r);
    }

    @Test
    public void SnailTest5() {
        int[][] array
                = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        int[] r = {1, 2, 3, 4, 5, 10, 15, 20, 25, 24, 23, 22, 21, 16, 11, 6, 7, 8, 9, 14, 19, 18, 17, 12, 13};
        test(array, r);
    }


    @Test
    public void SnailTest2() {
        int[][] array
                = {{1, 2},
                {3, 4}};
        int[] r = {1, 2, 4, 3};
        test(array, r);
    }

    @Test
    public void SnailTest1() {
        int[][] array
                = {{1}};
        int[] r = {1};
        test(array, r);
    }

    @Test
    public void SnailTest0() {
        int[][] array
                = {};
        int[] r = {};
        test(array, r);
    }

    @Test
    public void SnailTestEmpty() {
        int[][] array
                = {{}};
        int[] r = {};
        test(array, r);
    }

    public String int2dToString(int[][] a) {
        return Arrays.stream(a).map(Arrays::toString).collect(joining("\n"));
    }

    public void test(int[][] array, int[] result) {
        String text = int2dToString(array) + " should be sorted to " + Arrays.toString(result);
        System.out.println(text);
        Assertions.assertArrayEquals( result, Snail.snail(array));
    }

}