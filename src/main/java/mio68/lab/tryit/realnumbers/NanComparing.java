package mio68.lab.tryit.realnumbers;

public class NanComparing {

    public static void main(String[] args) {
        System.out.println(Float.NaN == Float.NaN); // Prints false!
        // If you wand to check if float or double is NaN use Float.isNaN(x) or Double.isNaN(x)
    }
}
