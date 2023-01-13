package mio68.lab.tryit.reflection;

import java.lang.reflect.Field;

public class ModifyStringWithReflection {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        String s = "Hello World!";
        System.out.println(s);

        Field f = s.getClass().getDeclaredField("value");
        f.setAccessible(true);
/* Got exception here!
        Exception in thread "main" java.lang.reflect.InaccessibleObjectException: Unable to make field private final byte[] java.lang.String.value accessible: module java.base does not "opens java.lang" to unnamed module @7ef20235
        at java.base/java.lang.reflect.AccessibleObject.checkCanSetAccessible(AccessibleObject.java:357)
        at java.base/java.lang.reflect.AccessibleObject.checkCanSetAccessible(AccessibleObject.java:297)
        at java.base/java.lang.reflect.Field.checkCanSetAccessible(Field.java:177)
        at java.base/java.lang.reflect.Field.setAccessible(Field.java:171)
        at mio68.lab.tryit.reflection.ModifyStringWithReflection.main(ModifyStringWithReflection.java:12)
*/
        f.set(s, "Hello Brave New World!".getBytes());
        System.out.println(s);
    }
}
