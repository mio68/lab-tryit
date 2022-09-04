package mio68.lab.tryit.streams;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SumOfIntArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(String.format(
                "%s = %d",
                Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(" + ")),
                Arrays.stream(nums).sum()));
    }
}
