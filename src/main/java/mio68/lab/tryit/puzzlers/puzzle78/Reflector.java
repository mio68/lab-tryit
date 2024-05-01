package mio68.lab.tryit.puzzlers.puzzle78;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Reflector {
    public static void main(String[] args) throws Exception {
        Set<String> s = new HashSet<>();
        s.add("foo");
        Iterator it = s.iterator();

        System.out.println(it.getClass()); // class java.util.HashMap$KeyIterator
        System.out.println(Iterator.class); // interface java.util.Iterator

        Method m = it.getClass().getMethod("hasNext");
//        This prints
//        Exception in thread "main" java.lang.IllegalAccessException: class mio68.lab.tryit.puzzlers.puzzle78.Reflector cannot access a member of class java.util.HashMap$HashIterator (in module java.base) with modifiers "public final"
//        at java.base/jdk.internal.reflect.Reflection.newIllegalAccessException(Reflection.java:392)
//        at java.base/java.lang.reflect.AccessibleObject.checkAccess(AccessibleObject.java:674)
//        at java.base/java.lang.reflect.Method.invoke(Method.java:560)
//        at mio68.lab.tryit.puzzlers.puzzle78.Reflector.main(Reflector.java:14)
 //       System.out.println(m.invoke(it));

        Method m2 = Iterator.class.getMethod("hasNext");
        System.out.println(m2.invoke(it)); // true
    }
}
