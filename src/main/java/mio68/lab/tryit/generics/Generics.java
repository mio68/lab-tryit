package mio68.lab.tryit.generics;

public class Generics {

    public static void main(String[] args) {
        Class<? extends Number> targetClass = getTargetClass();
        System.out.println(targetClass);

        // It's just ok!
        checkTargetClass(targetClass);

        // Compilation error.
        // java: incompatible types: java.lang.Class<capture#1 of ? extends java.lang.Number> cannot be converted to java.lang.Class<java.lang.Number>
//        Class<Number> numberClass = getTargetClass();

        // Warning: Raw use of parameterized class...
        Class aClass = getTargetClass();

        // Warning: unchecked assigment...
        checkTargetClass(aClass);

        // It's just OK!
        Class<?> unknownClass = getTargetClass();

        // Compilation error:
        // java: incompatible types: java.lang.Class<capture#1 of ?> cannot be converted to java.lang.Class<? extends java.lang.Number>
//        checkTargetClass(unknownClass);

        Integer i = 0;
        // It's just ok!
        checkTargetClass(i.getClass());
        // It's just ok!
        checkTargetClass(Number.class);
    }

    public static Class<? extends Number> getTargetClass() {
        return Integer.class;
    }

    public static void checkTargetClass(Class<? extends Number> tClass) {
        System.out.println(tClass);
    }
}
