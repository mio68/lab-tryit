package mio68.lab.tryit.generics;

import java.util.ArrayList;
import java.util.List;

public class Tests {
    public static void main(String[] args) {
        Class c = "42".getClass();
        Class<?> c2 = "42".getClass();
        Class<? extends String> c3 = "42".getClass();
//        Class<Integer> c4 = "42".getClass(); //illegal

        List<? extends Number> numbers = new ArrayList<>();
//        numbers.add(1);

//        numbers.add(new Object());

        numbers.add(null);
    }
}
