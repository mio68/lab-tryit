package mio68.lab.tryit.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tests2 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1,2));

        List<Integer> unmodifiable = Collections.unmodifiableList(list);
        list.add(3);

        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(Arrays.toString(unmodifiable.toArray()));


    }

}
