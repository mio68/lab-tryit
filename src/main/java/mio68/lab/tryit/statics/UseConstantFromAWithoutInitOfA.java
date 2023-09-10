package mio68.lab.tryit.statics;

// Doesn't initialize A class
public class UseConstantFromAWithoutInitOfA {
    public static void main(String[] args) {
        System.out.println(A.HELLO_A);
    }
}
