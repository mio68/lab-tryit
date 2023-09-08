package mio68.lab.tryit.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class A {
    private String motto = "I am private string!";
    private void method() {
        System.out.println("I am private method");
    }
}

public class AccessToPrivateMember {

    public static void main(String[] args)
            throws NoSuchFieldException,
            IllegalAccessException,
            NoSuchMethodException,
            InvocationTargetException {

        A a = new A();
        Field motto = A.class.getDeclaredField("motto");
        motto.setAccessible(true);
        System.out.println(motto.get(a)); // I am private string!
        motto.set(a, "You are hacked!");
        System.out.println(motto.get(a)); // You are hacked!

        Method method = A.class.getDeclaredMethod("method", null);
        method.setAccessible(true);
        method.invoke(a); // I am private method
    }

}
