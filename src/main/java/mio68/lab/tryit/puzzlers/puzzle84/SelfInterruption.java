package mio68.lab.tryit.puzzlers.puzzle84;

public class SelfInterruption {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().isInterrupted());
        if (Thread.interrupted()) {
            System.out.println("Interrupted " + Thread.interrupted());
        } else {
            System.out.println("Not interrupted " + Thread.interrupted());
        }
    }
}
