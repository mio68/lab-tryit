package mio68.lab.tryit.varargs;

public class Varargs {

    public void m(String s1, String s2) {
        System.out.println("method with two parameters is called.");
    }

    public void m(String... strings) {
        System.out.println("method with vararg is called.");
    }

    public static void main(String[] args) {
        Varargs varargs = new Varargs();

        varargs.m("one", "two"); // method with two parameters is called.
        varargs.m("one"); //method with vararg is called.
    }
}
