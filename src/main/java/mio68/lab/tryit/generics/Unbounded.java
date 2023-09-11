package mio68.lab.tryit.generics;

import mio68.lab.tryit.builder.A;

import java.util.ArrayList;
import java.util.List;

public class Unbounded {
    public static void main(String[] args) {
        List<?> unbounded = new ArrayList<String>();
        unbounded.clear();
//        unbounded.add(42); // illegal
//        unbounded.add(new Object()); // illegal two
        Object o = unbounded.get(0);
    }
}
