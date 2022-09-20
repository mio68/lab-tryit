package mio68.lab.tryit.nested;

public class OuterWithStaticNested {

    private static String title = "Title";

    private String privateName;

    private void method(StaticNested nested) {
        int r = nested.privateField; // Access to private field of nested.
    }

    private static class StaticNested {
        private int privateField = 0;
        private static void staticMethod() {
            System.out.println(title); // access to static private memeber of enclosing class
//            System.out.println(name); // Impossible!
        }

        private void instanceMethod() {
            System.out.println(title); // access to static private memeber of enclosing class
//            System.out.println(name); // Impossible!
        }

        private void staticMethod(OuterWithStaticNested outer) {
            String s = outer.privateName; // Access to instance
        }
    }

    public static void main(String[] args) {
        StaticNested staticNested = new StaticNested();
        // or
        StaticNested staticNested1 = new OuterWithStaticNested.StaticNested();
    }
}
