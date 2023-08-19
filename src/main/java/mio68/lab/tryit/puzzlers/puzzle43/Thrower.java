package mio68.lab.tryit.puzzlers.puzzle43;

import java.awt.*;

public class Thrower {
    private static Throwable throwable;

    public Thrower() throws Throwable {
        throw throwable;
    }

    public static synchronized void sneakyThrow(Throwable t) {
        try {
            Thrower.throwable = t;
            Thrower.class.newInstance();
        } catch (InstantiationException e) {
            System.err.println("InstantiationException can't be thrown");
        } catch (IllegalAccessException e) {
            System.err.println("IllegalAccessException can't be thrown");
        } finally {
            Thrower.throwable = null;
        }
    }

    public static void main(String[] args) {
        try {
           sneakyThrow(new Exception("Sneaky throw"));
//            sneakyThrow(new InstantiationException()); //is not supported
//            sneakyThrow(new IllegalAccessException()); //is not supported
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Done!");
    }

}
