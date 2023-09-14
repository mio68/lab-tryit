package mio68.lab.tryit.concurrency;

public class Test6 {

    private String monitor = "mon";

    public void w() throws InterruptedException {
        monitor.wait();
    }

    public void n() {
        monitor.notify();
    }

    public static void main(String[] args) throws InterruptedException {
        Test6 t = new Test6();
        t.n();
    }

}

