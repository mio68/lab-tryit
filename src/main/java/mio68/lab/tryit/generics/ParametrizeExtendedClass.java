package mio68.lab.tryit.generics;

public class ParametrizeExtendedClass {

    static class A {
        private int id = 1;

        public int getId() {
            return id;
        }
    }

    static class B<T> {

    }

    static class C<T> extends A {
        private T t;

        void setT(T t) {
            this.t = t;
        }

        T getT() {
            return t;
        }
    }

    public static void main(String[] args) {
        C<String> c = new C<>();
        System.out.println(c.getId());
        c.setT("Hello!");
        System.out.println(c.getT());
    }

}
