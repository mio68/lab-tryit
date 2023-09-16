package mio68.lab.tryit.inheritance.p1;

public class A implements I {
    @Override
    public void method() {
//        staticMethod(); //can't resolve
        I.staticMethod(); // it's ok
    }

    public static void main(String[] args) {
        A a = new A();
//        a.staticMethod(); // can't resolve
    }

}
