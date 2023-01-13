package mio68.lab.tryit.generics;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiscoverTypeParameter {

    private final List<Integer> integers = new ArrayList<>();

    public static void main(String[] args) throws NoSuchFieldException {

        // Try to discover type parameter of strings
//        List<String> strings = new ArrayList<>();
//
//        System.out.println(strings.getClass());
//
//        Type genericSuperclass = strings.getClass().getGenericSuperclass();
//        System.out.println(genericSuperclass);
//
//        TypeVariable<? extends Class<? extends List>>[] typeParameters = strings.getClass().getTypeParameters();
//        for (var typeVar : typeParameters) {
//            System.out.println(typeVar);
//        }

        // Try to discover type parameter for DiscoverTypeParameter.integers
        Field field = DiscoverTypeParameter.class.getDeclaredField("integers");
        System.out.println(field.getType()); // interface java.util.List
        Type fieldGenericType = field.getGenericType();
        System.out.println(fieldGenericType); // java.util.List<java.lang.Integer> !!!

        if (fieldGenericType instanceof ParameterizedType parameterizedType) {
            Type[] typeArguments = parameterizedType.getActualTypeArguments();
            System.out.println(Arrays.toString(typeArguments)); // Wow! [class java.lang.Integer]
        }

    }

}
