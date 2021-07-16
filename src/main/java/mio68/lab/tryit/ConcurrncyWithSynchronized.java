package mio68.lab.tryit;

/**
 * Never stops without synchronized!
 * It makes 33666048 cycles.
 * 44 times less than ConcurencyWithVolatile
 */
public class ConcurrncyWithSynchronized {
    private static boolean stop = false;

    public static synchronized boolean isStop() {
        return stop;
    }

    public static synchronized void setStop(boolean stop) {
        ConcurrncyWithSynchronized.stop = stop;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread( () -> {
            int counter = 0;
            while ( !isStop() ) {
                counter++;
            }
            System.out.printf("cycle counter:%d%n", counter);
        });

        t.start();

        Thread.sleep(1000);

        setStop(true);

    }
}