package mio68.lab.tryit.concurrency;


class LongHandler {
    volatile long value = 1;

    void setValue(long value) {
        this.value = value;
    }

    long getValue() {
        return value;
    }

    synchronized long incAndGet() {
        long res = ++value;
        System.out.println(res);
        return res;
    }

}

public class Tests {

    public static void main(String[] args) {


    }

}
