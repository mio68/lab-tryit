package mio68.lab.tryit;

/**
 * Never stops without volatile!
 * It makes 1517543221 cycles.
 * 44 times more than ConcurencyWithSynchronized
 */
public class ConcurencyWithVolatile {
    public static volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
	    Thread t = new Thread( () -> {
	        int counter = 0;
	       while ( !stop ) {
	           counter++;
           }
            System.out.printf("cycle counter:%d%n", counter);
        });

	    t.start();

	    Thread.sleep(1000);
	    stop = true;

    }
}
