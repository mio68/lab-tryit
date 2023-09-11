package mio68.lab.tryit.generics;

import java.util.ArrayList;
import java.util.List;

public class Raw {
    public static void main(String[] args) {
        List raw = new ArrayList<String>();
        raw.clear();
        raw.add(42);
        System.out.println(raw);
        Object o = raw.get(0);
    }
}
