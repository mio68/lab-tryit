package mio68.lab.tryit.overloading;

public class Tests {
    public static void main(String[] args) {
        Double d = 20.0;
//        printInt(d); // java: incompatible types: java.lang.Double cannot be converted to int
    }

    public static void printInt(int i) {
        System.out.println(i + " ");
    }
}
