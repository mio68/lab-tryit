package mio68.lab.tryit.generics;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @link https://en.wikipedia.org/wiki/Heap_pollution
 */
public class HeapPollutionDemo {
    public static void main(String[] args) {
        Set s = new TreeSet<Integer>();
        s.add(Integer.valueOf(42));          // another unchecked warning

        Set<String> ss = s;              // unchecked warning
        Iterator<String> iter = ss.iterator();
        while (iter.hasNext()) {
            String str = iter.next();    // ClassCastException thrown
            System.out.println(str);
        }
    }
}