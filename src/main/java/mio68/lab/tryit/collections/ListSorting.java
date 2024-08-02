package mio68.lab.tryit.collections;

import java.util.ArrayList;
import java.util.List;

public class ListSorting {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("B", "D", "A", "C"));
        list.sort(String::compareTo);
        System.out.println(list);
    }
}
