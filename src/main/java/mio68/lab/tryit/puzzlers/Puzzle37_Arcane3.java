package mio68.lab.tryit.puzzlers;

interface Type1 {
    void f() throws CloneNotSupportedException;
}

interface Type2 {
    void f() throws InterruptedException;
}

interface Type3 extends Type1, Type2 {
}

public class Puzzle37_Arcane3 implements Type3 {
    public void f() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        Type3 t3 = new Puzzle37_Arcane3();
        t3.f();
    }
}
