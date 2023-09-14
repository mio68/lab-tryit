package mio68.lab.tryit.lang;

public class Tests {

    static class A {}
    static class B extends A {}

    public static void main(String[] args) {

        A ref1 = new B();
        A ref2 = new A();

        System.out.println(ref1 instanceof A);

//        System.out.println(ref1 instanceof ref2.getClass()); // invalid

        System.out.println(ref2.getClass().isAssignableFrom(ref1.getClass()));

    }

}
