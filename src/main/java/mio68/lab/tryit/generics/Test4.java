package mio68.lab.tryit.generics;

import java.io.Serializable;
import java.lang.reflect.Field;

public class Test4 {
}


class A implements Serializable {
    public static void main(String[] args) throws NoSuchFieldException {
        Clazz<B> clazz = new Clazz<B>();

        Field field = clazz.getClass().getDeclaredField("field");
        System.out.println(field.getType());

    }
}

class B extends A {}

class Clazz <T extends B> {
    private T field;
}