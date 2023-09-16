package mio68.lab.tryit.shadow;

class Outer {

    String field = "field of outer";

    void m() {
        System.out.println("method of outer");
    }

    class Inner {
        String field = "field of inner";

        void m() {
            System.out.println("method of inner");
        }

        void test() {
            System.out.println(field);  // prints "field of inner"
            m();                        // prints "method of inner"
        }

        void test2() {
            System.out.println(this.field); // prints "field of inner"
            this.m();                       // prints "method of inner"
            System.out.println(this.getClass().getSimpleName()); // Inner
        }

        // How to get field of outer? Use <OuterType>.this
        void test3() {
            System.out.println(Outer.this.field);
            Outer.this.m();
            System.out.println(Outer.this.getClass().getSimpleName());
        }

    }

}

public class OuterMembersShadowedByInnerMembers {

    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        inner.test(); // uses inner members
        inner.test2(); // uses inner members
        inner.test3(); // uses outer members
    }

}