package mio68.lab.tryit.debug;

public class Tests {
    public static void main(String[] args) {
        print(1);
    }

    public static void print(Object o) {
        String s = o.toString();
        System.out.println(s);
    }
}
