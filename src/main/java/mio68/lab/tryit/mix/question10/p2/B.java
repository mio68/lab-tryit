package mio68.lab.tryit.mix.question10.p2;

import mio68.lab.tryit.mix.question10.p1.*;

/**
 * Данный вопрос отражает важное свойство спецификатора доступа protected. Во всех книгах
 * и статьях пишут, что члены с доступом protected видны в данном пакете и в подклассах
 * других пакетов. Но мало кто уточняет, что за пределами пакета данные члены видны ТОЛЬКО
 * ЧЕРЕЗ НАСЛЕДОВАНИЕ.
 */
public class B extends A{
    public void process(A a) {
        //Compilation error
        // java: i has protected access in mio68.lab.tryit.mix.question10.p1.A
        // If A is moved to package p2 - then it's field i is accesible by B
//        a.i = a.i*2;
    }
    public static void main(String[] args) {
        A a = new B();
        B b = new B();
        b.process(a);
        System.out.println( a.getI() );
    }
}