package mio68.lab.tryit.puzzlers.puzzle76;

public class PingPong {
    public static synchronized void main(String[] args) {
        Thread t = new Thread() {
          public void run() {
              pong();
          }
        };

        t.run();
        System.out.println("Ping");
    }

    static synchronized void pong() {
        System.out.println("Pong");
    }
}
