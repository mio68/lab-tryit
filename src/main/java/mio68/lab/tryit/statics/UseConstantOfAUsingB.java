package mio68.lab.tryit.statics;

// Doesn't initialize A and B
public class UseConstantOfAUsingB {
    public static void main(String[] args) {
        System.out.println(B.HELLO_A);
    }
}
