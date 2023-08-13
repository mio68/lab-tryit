package mio68.lab.tryit.interfaces;

interface Top {
    default void m() {
        System.out.println("Top");
    }
}

interface Left extends Top {

}

interface Right extends Top {
    default void m() {
        System.out.println("Right");
    }
}

// This interface inherits m() from Right
interface Bottom extends Left, Right{

}

public class PreventReinheriting {
    public static void main(String[] args) {
        Bottom bottom = new Bottom() {
        };
        bottom.m(); // Prints Right
    }
}