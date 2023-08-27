package mio68.lab.tryit.puzzlers.puzzle60;

public class D {

    public static boolean isFirstIntHasMoreBitsSet(int i, int j) {
        return Integer.bitCount(i) > Integer.bitCount(j);
    }

}
