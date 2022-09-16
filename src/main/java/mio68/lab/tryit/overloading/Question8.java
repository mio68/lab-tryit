package mio68.lab.tryit.overloading;

/**
 * See https://habr.com/ru/post/111189/
 * inside long
 */

public class Question8 {
    static void method(int... a) {
        System.out.println("inside int...");
    }

    static void method(long a, long b) {
        System.out.println("inside long");
    }

    static void method(Integer a, Integer b) {
        System.out.println("inside INTEGER");
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        method(a, b);
    }
}
