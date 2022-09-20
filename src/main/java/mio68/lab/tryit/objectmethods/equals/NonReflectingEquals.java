package mio68.lab.tryit.objectmethods.equals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NonReflectingEquals {

    private static class Thing {
        private final int id;

        private Thing(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Thing other)) {
                return false;

            }
            // Broke contract of o.equals(o) == true
            if (this == other) {
                return false;
            } else {
                return this.id == other.id;
            }
        }

        @Override
        public int hashCode() {
            return 42;
        }
    }

    public static void main(String[] args) {

        Thing thing = new Thing(1);
        Thing thing2 = new Thing(1);
        Thing thing3 = new Thing(1);

        EqualContractChecker.printEqualContractInfo(thing, thing2, thing3);

        HashSet<Thing> set = new HashSet<>();

        set.add(thing);
        set.add(thing2);
        set.add(thing);

        System.out.println(set.size()); // 1
        System.out.println(set.contains(thing)); // true
        System.out.println(set.contains(thing2)); // true
        System.out.println(set.contains(thing3)); // true


        List<Thing> list = new ArrayList<>();

        list.add(thing);
        list.add(thing2);
        list.add(thing);

        System.out.println(list.size()); // 3
        System.out.println(list.contains(thing)); // true
        System.out.println(list.contains(thing2)); // true
        System.out.println(list.contains(thing3)); // true
    }

}
