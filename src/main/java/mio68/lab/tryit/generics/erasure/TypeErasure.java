package mio68.lab.tryit.generics.erasure;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TypeErasure<T> {
    <E> void getParameterType(List<E> list) {
        TypeVariable<? extends Class<? extends List>>[] typeParameters
                = list.getClass().getTypeParameters();
        System.out.println(Arrays.asList(typeParameters));
    }

    static void printTypeParameter(Class<?> clazz) {
        System.out.println(
                ((ParameterizedType)clazz.getGenericSuperclass()).getActualTypeArguments()[0]
        );
    }


    public static void main(String[] args) {
        TypeErasure<String> typeErasure = new TypeErasure<>();
        typeErasure.getParameterType(new ArrayList<String>());
        typeErasure.getParameterType(new ArrayList<Integer>());

        printTypeParameter((new ArrayList<String>()).getClass());
        printTypeParameter((new IntegerList()).getClass());
    }

    static class IntegerList extends ArrayList<Integer> {

    }
}
