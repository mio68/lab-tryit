package mio68.lab.tryit.overloading;

public class Tests2 {
    public static void main(String[] args) {
        byte b = 1;
        int i = 1;
        printIt(b + i);
        printIt(b + b);
    }

    private static void printIt(byte val) {
        System.out.println("Byte val " + val);
    }

    private static void printIt(int val) {
        System.out.println("Int val " + val);
    }

}
