package mio68.lab.tryit.mix;

public class InstanceOfNull {

    public static void main(String[] args) {
        Integer i = null;
        Integer j = 1;

        System.out.println(i instanceof Integer); // Prints false
        System.out.println(j instanceof Integer); // Prints true
    }
}
