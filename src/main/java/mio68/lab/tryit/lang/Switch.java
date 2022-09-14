package mio68.lab.tryit.lang;

public class Switch {

    public static void main(String[] args) {

        String s = "one";

//        If s is null it throws:
//        Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.hashCode()" because "<local2>" is null
//        at mio68.lab.tryit.lang.Switch.main(Switch.java:9)
        switch (s) {
            // case requires a constant
            // case <constant> :
            case "one":
                System.out.println("One!"); break;

            case "two":
                System.out.println("Two!"); break;

            default:
                System.out.println("Default!");
        }

//        Compilation error:
//        char, byte, short, int, Character, Byte, Short, Integer, String, enum are required!
//        boolean b = true;
//        switch(b) {
//            case Boolean.TRUE:
//                System.out.println(Boolean.TRUE); break;
//            default:
//                break;
//        }


//        Switch expression is null!
//        Type type = null;
//        System.out.println( type == Type.A);
//        Exception in thread "main" java.lang.NullPointerException:
//        Cannot invoke "mio68.lab.tryit.lang.Switch$Type.ordinal()" because "type" is null
//        switch (type) {
//            case A:
//                System.out.println(Type.A); return;
//            case B:
//                System.out.println(Type.B); return;
//            default:
//                System.out.println(type);
//
//        }

    }

    public enum Type {
        A, B, C
    }

}
