package mio68.lab.tryit.puzzlers.puzzle50;

public class Type3 {
    public static void main(String[] args) {
        // Runtime error
        // Exception in thread "main" java.lang.ClassCastException: class java.lang.Object cannot be cast to class mio68.lab.tryit.puzzlers.puzzle50.Type3 (java.lang.Object is in module java.base of loader 'bootstrap'; mio68.lab.tryit.puzzlers.puzzle50.Type3 is in unnamed module of loader 'app')
        //	at mio68.lab.tryit.puzzlers.puzzle50.Type3.main(Type3.java:5)
        Type3 t3 = (Type3) new Object();
    }
}
