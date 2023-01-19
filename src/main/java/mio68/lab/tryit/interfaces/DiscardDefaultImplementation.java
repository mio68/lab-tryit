package mio68.lab.tryit.interfaces;

public class DiscardDefaultImplementation {

    interface A {
        default void hello() {
            System.out.println("Hello from A!");
        }
    }

    interface B extends A{
        void hello();  // B discards default implementation for A
    }

    static class D implements B {

        @Override
        public void hello() {
            System.out.println("Hello from D!");
        }
    }

}
