package mio68.lab.tryit.puzzlers;

public class GhostOfLooper {
    public static void main(String[] args) throws InterruptedException {
//        short i = -1; // infinity loop! because i >>>= 1 -> i = (short) ( (int)i >>> 1)
                        // narrowing can change sign!
//        byte i = -1; // infinity loop! just the same reason.
        byte i = -128; // infinity loop! just the same reason.
//        int i = -1; // 32 cycles

        long counter = 0;
        while (i != 0) {
            i >>>= 1;
            System.out.printf("%s: %s%n", ++counter, Integer.toBinaryString(i));
            Thread.sleep(500);
        }
    }
}
