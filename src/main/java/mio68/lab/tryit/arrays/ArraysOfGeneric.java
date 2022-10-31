package mio68.lab.tryit.arrays;

import java.util.List;

public class ArraysOfGeneric {

    public static void main(String[] args) {

        creationOfGenericTypeArrayIsProhibited();
        declaringArrayOfParametrizedType();

    }

    public static void creationOfGenericTypeArrayIsProhibited() {
        // Compilation: java: generic array creation
        // It guaranties type safe for cases like described below.
//        List<String>[] lists = new List<String>[1];

        // Compilation: OK - because arrays are covariant
        // Runtime: OK
//        Object[] objects = lists;

//        List<Integer> integers = List.of(1);
        // Compilation: OK , List<Integer> is subtype of Object;
        // Runtime: OK - because of type erasure, runtime objects type is List[]
        // and integers runtime type is List[] too;
//        objects[0] = integers;

        // Compilation: OK
        // Runtime: class cast exception - lists[0].get(0) type is Integer;
//        String s = lists[0].get(0);

    }

    public static void declaringArrayOfParametrizedType() {

        // Compilation: OK, with WARNING: ArraysOfGeneric.java uses unchecked or unsafe operations.
        // To suppress you can use the following annotation
        //@SuppressWarnings("unchecked")
        List<String>[] lists = new List[1];

        // Prints: List<String>[] lists runtime type is: class [Ljava.util.List
        // because of type erasure
        System.out.println("List<String>[] lists runtime type is: " + lists.getClass());

        // Compilation: OK - because arrays are covariant
        // Runtime: OK
        Object[] objects = lists;

        List<Integer> integers = List.of(1);
        // Compilation: OK , List<Integer> is subtype of Object;
        // Runtime: OK - because of type erasure, runtime objects type is List[]
        // and integers runtime type is List[] too;
        objects[0] = integers;

        // Compilation: OK
        // Runtime: class cast exception - lists[0].get(0) type is Integer;
        // Exception in thread "main" java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String (java.lang.Integer and java.lang.String are in module java.base of loader 'bootstrap')
        String s = lists[0].get(0);
        System.out.println(s);
    }

}
