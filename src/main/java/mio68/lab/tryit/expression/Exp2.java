package mio68.lab.tryit.expression;

public class Exp2 {
    public static void main(String[] args) {
        int num = 101;

        num = (num >> 2) * 4;
        System.out.println(num);

        num = 101;
        num = num >> 2 * 4;
        System.out.println(num);

    }
}
