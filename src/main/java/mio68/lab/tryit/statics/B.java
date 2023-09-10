package mio68.lab.tryit.statics;

class B extends A {
    static {
        System.out.println("B is initialized");
    }

    static void methB() {
        System.out.println("methB!");
    }
}
