package mio68.lab.tryit.thread;

//https://stackoverflow.com/questions/25672393/where-is-notifyall-getting-called-at-the-end-of-thread-join

// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Thread.html
// public final void join(long millis, int nanos) throws InterruptedException
// As a thread terminates the this.notifyAll method is invoked.
// It is recommended that applications not use wait, notify, or notifyAll on
// Thread instances.

public class ThreadAsMonitor {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() ->
                System.out.println(
                        String.format(
                                "Thread name [%s], id [%s] end.",
                                Thread.currentThread().getName(),
                                Thread.currentThread().getId())));

        System.out.println("Thread hash " + thread.hashCode());

        synchronized (thread) {
            thread.start();
            System.out.println("Thread state is " + thread.getState());
            thread.wait();
        }

        System.out.println("Main end.");
    }
}
