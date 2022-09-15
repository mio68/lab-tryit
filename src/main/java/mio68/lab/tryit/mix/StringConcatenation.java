package mio68.lab.tryit.mix;

public class StringConcatenation {

    public static void main(String[] args) {

        String hel = "Hel";
        String lo = "lo";

        System.out.println("Hello" == "Hel" + "lo"); // true
        System.out.println("Hello" == ("Hel" + lo)); // false
        System.out.println("Hello" == ("Hel" + lo).intern()); // true
        System.out.println("Hello" == (hel + lo)); // false
        System.out.println("Hello" == (hel + lo).intern()); //true

    }
}
