package mio68.lab.tryit.puzzlers.puzzle49;

import java.util.Calendar;

public class Elvis {
    private static final Elvis INSTANCE = new Elvis();
    private final int beltSize;
    private static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);

    private Elvis() {
        beltSize = CURRENT_YEAR - 1930;
    }

    public int beltSize() {
        return beltSize;
    }

    public static void main(String[] args) {
        System.out.println("Elvis wear a size " +
                INSTANCE.beltSize() + " belt"); // It prints -1930
    }
}
