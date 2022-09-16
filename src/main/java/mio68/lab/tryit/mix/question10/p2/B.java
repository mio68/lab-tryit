package mio68.lab.tryit.mix.question10.p2;

import mio68.lab.tryit.mix.question10.p1.*;

public class B extends A{
    public void process(A a) {
        //Compilation error
        // java: i has protected access in mio68.lab.tryit.mix.question10.p1.A
//        a.i = a.i*2;
    }
    public static void main(String[] args) {
        A a = new B();
        B b = new B();
        b.process(a);
        System.out.println( a.getI() );
    }
}