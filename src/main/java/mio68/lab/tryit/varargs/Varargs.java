package mio68.lab.tryit.varargs;

public class Varargs {

    public void m(String s1, String s2) {
        System.out.println("method with two parameters is called.");
    }
/*
    Если метод использует переменное количество
    параметров, консервативная стратегия заключается в том, чтобы не перегружать его
    вовсе...
*/
    public void m(String... strings) {
        System.out.println("method with vararg is called.");
    }

/*
    Adding of this method leads to ambiguity!
    java: reference to m is ambiguous
    both method m(java.lang.String...) in mio68.lab.tryit.varargs.Varargs and
    method m(java.lang.String,java.lang.String...) in mio68.lab.tryit.varargs.Varargs match
*/
//    public void m(String s, String... strings) {
//        System.out.println("Adding of this method leads to ambiguity!");
//    }

    public static void main(String[] args) {
        Varargs varargs = new Varargs();

        varargs.m("one", "two"); // method with two parameters is called.

        varargs.m("one", "two", "three"); //method with vararg is called.
        varargs.m("one"); //method with vararg is called.
        varargs.m(); //method with vararg is called.
    }
}
