package mio68.lab.tryit.mix;

public class PatternMatchingInstanceOf {

    public static void main(String[] args) {

        Object o = "Hello!";

//        o = Integer.valueOf(1);

        if (o instanceof String aString) {
            System.out.println("This is a String!");
        } else if (o instanceof Integer anInteger) {
            System.out.println("This is an Integer, and it's value plus 1 is: " +(anInteger + 1));
        }

    }
}
