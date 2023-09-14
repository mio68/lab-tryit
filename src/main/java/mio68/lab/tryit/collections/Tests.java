package mio68.lab.tryit.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tests {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        System.out.println(list);

//        list.remove((Integer)1);
//        List<Integer> toBeRemoved = List.of(1);
//        list.removeAll(toBeRemoved);
//        System.out.println(list);

        for (Integer i : list) {
            if ( i == 1)
                list.remove(i);
        }

    }
}
