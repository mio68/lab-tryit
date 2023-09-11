package mio68.lab.tryit.nested;

import mio68.lab.tryit.builder.A;

import java.util.Objects;

public class Tests {
    static class Abstract {}

    public static Abstract getConcrete() {
        return new Abstract() {};
    }

    public static void main(String[] args) {
        Abstract obj1 = new Abstract() {};
        Abstract obj2 = new Abstract() {};
        boolean b1 = compareClasses(obj1, obj2); // false
        boolean b2 = compareClasses(getConcrete(), new Abstract() {}); // false
        boolean b3 = compareClasses(getConcrete(), getConcrete()); // true
        boolean b4 = compareClasses(obj1, getConcrete()); // false
        boolean b5 = compareClasses(obj1, obj1); // true

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
        System.out.println(b5);
    }

    public static boolean compareClasses(Object o1, Object o2) {
        System.out.println(o1.getClass());
        System.out.println(o2.getClass());
        return o1.getClass() == o2.getClass();
    }
}
