package mio68.lab.tryit.statics;

/*
A class or interface type T will be initialized immediately before the first occurrence of any one of the following:

    T is a class and an instance of T is created.

    A static method declared by T is invoked.

    A static field declared by T is assigned.

    A static field declared by T is used and the field is not a constant variable
 */
class A {
    static {
        System.out.println("A is initialized");
    }

    static final String HELLO_A = "Hello A";
    static final long TIMESTAMP = System.currentTimeMillis();

    static void methA() {
        System.out.println("methA!");
    }
}
