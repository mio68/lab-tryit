package mio68.lab.tryit.nested;

public class OuterWithStaticNested {

    private static String title = "Title";

    private String name;

    private static class StaticNested {

        private static void staticMethod() {
            System.out.println(title); // access to static private memeber of enclosing class
//            System.out.println(name); // Impossible!
        }

        private void instanceMethod() {
            System.out.println(title); // access to static private memeber of enclosing class
//            System.out.println(name); // Impossible!
        }
    }

    public static void main(String[] args) {
        StaticNested staticNested = new StaticNested();
        // or
        StaticNested staticNested1 = new OuterWithStaticNested.StaticNested();
    }
}
