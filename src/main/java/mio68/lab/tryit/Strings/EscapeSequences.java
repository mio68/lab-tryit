package mio68.lab.tryit.Strings;

public class EscapeSequences {


    public static void main(String[] args) {
        String s = "\b \t \n \f \r \" \' \\"; // prints  " ' \
        System.out.println(s);

        System.out.println("Hello World\b"); // Hello Worl
        System.out.println("Hello \tWorld");
        System.out.println("Hello World\f"); // Hello World
        System.out.println("Hello World\r");

        System.out.println((int)'A'); // 65 (decimal) -> 101 (octal)
        System.out.println("\101"); // A
        System.out.println("test");
    }

}
