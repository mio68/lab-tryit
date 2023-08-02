package mio68.lab.tryit.puzzlers;

public class Puzzle12_Abc {
    public static void main(String[] args) {
        String letters = "ABC";
        char[] numbers = {'1', '2', '3'};
        System.out.println(letters + " easy as " + numbers); // prints something like ABC easy as [C@12edcd21
        System.out.println(numbers[0]); // prints 1
        System.out.println(numbers); // prints 123
        // fix it!
        System.out.println(letters + " easy as " + String.valueOf(numbers));
    }
}
