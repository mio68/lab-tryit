package mio68.lab.tryit.generics.p2;

import java.util.ArrayList;
import java.util.List;

// PECS
// producer - extends, consumer -  super
public class Test {

    public static void main(String[] args) {
        List<C> listOfC = new ArrayList<>();

        Number n;
        A a;
        B b;
        // Producers
        List<? extends Number> lst1 = listOfC; n = lst1.get(0);
        List<? extends A> lst2 = listOfC; n = lst2.get(0); a = lst2.get(0);
        List<? extends B> lst3 = listOfC; n = lst3.get(0); a = lst3.get(0); b = lst3.get(0);

        //List<? super Number> consumer of Number
//        List<? super Number> lst4 = listOfC; // illegal

        //consumer of A
//        List<? super A> lst5 = listOfC; // illegal

        //consumer of B
//        List<? super B> lst5 = listOfC; // illegal

        //consumer of C
        List<? super C> lst6 = listOfC; // OK
        lst6.add(new C());
    }
}
