package mio68.lab.tryit.concurrency;

/*
 *   https://www.baeldung.com/java-singleton-double-checked-locking
 *   This is not thread-safe! See Java Concurrency in practice.
 */
public class Singleton {

    private static volatile Singleton INSTANCE;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }

}
