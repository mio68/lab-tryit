package mio68.lab.tryit.puzzlers;

// Puzzle 10 is not actual with Java 17!
public class Puzzle10_Tweedledee {
    public static void main(String[] args) {
        Object x = "Hello ";
        String i = "World!";

        x = x + i; // Legal
        System.out.println(x);

        x = "Hello ";
        i = "World!";

        x += i; // It's legal too!
        System.out.println(x);
    }
}
