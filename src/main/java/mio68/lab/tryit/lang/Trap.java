package mio68.lab.tryit.lang;

import java.util.Arrays;

public class Trap {
    {
        System.out.println("Init");
    }

    static {
        System.out.println("Static");
        System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
    }

    public Trap() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        new Trap();
    }

}
