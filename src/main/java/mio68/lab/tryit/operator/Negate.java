package mio68.lab.tryit.operator;

public class Negate {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE); // prints -2147483648
        System.out.println(-Integer.MIN_VALUE); // prints -2147483648 again
        System.out.println(Math.abs(Integer.MIN_VALUE)); // and prints the same -2147483648
    }
}
