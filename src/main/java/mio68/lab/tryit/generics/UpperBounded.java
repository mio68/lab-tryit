package mio68.lab.tryit.generics;

import mio68.lab.tryit.model.Index;

import java.util.ArrayList;
import java.util.List;

public class UpperBounded {
    public static void main(String[] args) {
        List<? extends Number> numbers = new ArrayList<Integer>();
//        numbers.add(1); // illegal
//        numbers.add(new Object()); // illegal
        numbers.add(null); // ol
    }
}
