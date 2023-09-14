package mio68.lab.tryit.concurrency;

public class Test4 {

    String s;
    Integer i;

    public void m() {

        synchronized (s) {
            synchronized (i) {
                System.out.println("Hi");
            }
        }
     }

}
