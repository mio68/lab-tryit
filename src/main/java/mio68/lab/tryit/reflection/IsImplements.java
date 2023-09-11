package mio68.lab.tryit.reflection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsImplements {
    public static void main(String[] args) throws ClassNotFoundException {
//        System.out.println(ArrayList instanceof List);
        System.out.println(Integer.class instanceof Object);
        System.out.println(List.class.isAssignableFrom(ArrayList.class));
        System.out.println(
                Arrays.asList(Class.forName("java.util.ArrayList").getInterfaces())
        );
        System.out.println(
                Arrays.asList(Class.forName("java.util.ArrayList").getInterfaces()).contains(List.class)
        );
        System.out.println(
                Arrays.asList(ArrayList.class.getAnnotatedInterfaces())
        );
        System.out.println(
                Arrays.asList(ArrayList.class.getAnnotatedInterfaces()).contains(List.class)
        );

        A ref1 = new B();
        A ref2 = new A();
        Class<? extends A> aClass = ref2.getClass();

        System.out.println(ref1 instanceof A);
        System.out.println(ref1 instanceof B);
        System.out.println(ref1.getClass() == ref2.getClass());
//        System.out.println(ref1 instanceof ref2.getClass() );


    }

    static class A {

    }

    static class B extends A {

    }
}
