package mio68.lab.tryit.concurrency;

import mio68.lab.tryit.simple.A;

import java.util.concurrent.atomic.AtomicInteger;

public class Test5 {
    public static void main(String[] args) {
        AtomicInteger value = new AtomicInteger(5);
        System.out.println(value.compareAndSet(5,5));

    }
}
