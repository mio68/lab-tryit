package mio68.lab.tryit.interfaces;

public interface InterfaceWithNewFeatures {

    String MSG = "Hello!";

    static void helloStatic() {
        printStatic("Hello Class!");
    }

    default void hello() {
        print("Hello instance!");
    }

    private static void printStatic(String msg) {
        System.out.println(msg);
    }

    private void print(String msg) {
        System.out.println(msg);
    }

}
