package mio68.lab.tryit.mix;

public class Unbelievable {
    static Integer i;

    public static void main(String[] args) {
        if (i ==  42) // throws NullPointerException
            System.out.println("Невероятно");
    }
}