package mio68.lab.tryit.interfaces;

public class RhombusInheritance {

    interface A {
        default void hello() {
            System.out.println("Hello from A!");
        }
    }

    interface B {
        default void hello() {
            System.out.println("Hello from B!");
        }
    }

    static class D implements A, B {
        public void hello() {
            B.super.hello(); // Use hello from interface B
        }
    }

}
