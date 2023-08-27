package mio68.lab.tryit.operator;

public class Reminder {
    public static void main(String[] args) {
        System.out.println(5 % 2); // prints  1
        System.out.println(5 % -2); // prints 1
        System.out.println(-5 % 2); // prints -1
        System.out.println(-5 % -2); // prints -1

        System.out.println(Integer.MAX_VALUE % 2); // prints 1
        System.out.println(Integer.MIN_VALUE % 2); // prints 0
    }
}
