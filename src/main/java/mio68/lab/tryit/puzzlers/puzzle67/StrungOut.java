package mio68.lab.tryit.puzzlers.puzzle67;

public class StrungOut {

    public static void main(java.lang.String[] args) {
        main(new String[0]);
    }

    // LOL! It's not a main method))
    public static void main(String[] args) {
        String s = new String("Hello World!");
        System.out.println(s); // prints Hello World!
    }
}

class String {
    private final java.lang.String s;

    String(java.lang.String s) {
        this.s = s;
    }

    @Override
    public java.lang.String toString() {
        return s;
    }
}