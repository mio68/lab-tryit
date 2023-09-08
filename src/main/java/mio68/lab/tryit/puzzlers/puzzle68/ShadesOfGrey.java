package mio68.lab.tryit.puzzlers.puzzle68;


public class ShadesOfGrey {
    public static void main(String[] args) {
        System.out.println(X.Y.Z); // prints White!
        System.out.println((new X.Y()).Z); // prints Black!
        System.out.println(((X.Y)null).Z); // prints Black again!
    }
}

class X {
    static class Y {
        static String Z = "Black!";
    }

    static C Y = new C();
}

class C {
    String Z = "White!";
}