package mio68.lab.tryit.interfaces;

public class RhombusAgain {

    interface A {
        default Number getNum() {
            return 10;
        }
    }

    interface B {
        default Integer getNum() {
            return 42;
        }
    }

    // Compilation error!
//    java: types mio68.lab.tryit.interfaces.RhombusAgain.A and mio68.lab.tryit.interfaces.RhombusAgain.B are incompatible;
//    class mio68.lab.tryit.interfaces.RhombusAgain.D inherits unrelated defaults for getNum() from types mio68.lab.tryit.interfaces.RhombusAgain.A and mio68.lab.tryit.interfaces.RhombusAgain.B
//
//    static class D implements A, B {
//
//    }

    static class D implements A, B {
        public Integer getNum() {
            return B.super.getNum();
        }
    }

    public static void main(String[] args) {
        D d = new D();
        System.out.println(d.getNum()); // 42

        RhombusAgain.A a = (A) d;
        Number num = a.getNum();
        System.out.println(num); // 42

    }
}

