package mio68.lab.tryit.puzzlers.puzzle60;

import java.util.Arrays;
import java.util.Objects;

public class C {
    public static void main(String[] args) {
        Object[] arr = new String[][][]{
                {{"a"}, {"1", "2", "3"}},
                {{"b", "c"}, {"d"}, {"f"}}};
        System.out.println(Arrays.deepToString(arr));
    }
}
