package mio68.lab.tryit.puzzlers.puzzle80;

public class Outer {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        new Outer().greeting();
    }

    public void greeting() throws InstantiationException, IllegalAccessException {
//        Exception in thread "main" java.lang.InstantiationException: mio68.lab.tryit.puzzlers.puzzle80.Outer$Inner
//        at java.base/java.lang.Class.newInstance(Class.java:639)
//        at mio68.lab.tryit.puzzlers.puzzle80.Outer.greeting(Outer.java:9)
//        at mio68.lab.tryit.puzzlers.puzzle80.Outer.main(Outer.java:5)
//        Caused by: java.lang.NoSuchMethodException: mio68.lab.tryit.puzzlers.puzzle80.Outer$Inner.<init>()
//        at java.base/java.lang.Class.getConstructor0(Class.java:3585)
//        at java.base/java.lang.Class.newInstance(Class.java:626)
//	... 2 more
//        System.out.println(Inner.class.newInstance());

        System.out.println(new Inner()); // prints Hello World!
    }

    public class Inner {

        @Override
        public String toString() {
            return "Hello World!";
        }
    }
}
