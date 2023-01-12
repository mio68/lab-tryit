package mio68.lab.tryit.literal;

public class Literals {
    public static void main(String[] args) {
        // It is a compile-time error if a hexadecimal, octal, or binary int literal
        // does not fit in 32 bits.
        System.out.println(0x21L); // hexadecimal, prints 33
        System.out.println(041L); // octal, prints 33
        System.out.println(3_3L); // decimal, prints 33
        System.out.println(0b100001L); // binary, prints 33
        System.out.println("----------------------------------");

        char c = 65422;
        System.out.println(c); // prints ﾎ
        System.out.println((long)c); // prints 65422
        System.out.println((int)c); // prints 65422
        System.out.println((short)c); // prints -114

        short sh = -114;
        System.out.println((char)sh); // prints ﾎ

        System.out.println("---------------------");
        c = 0x2706;
        System.out.println((int)c);
        System.out.println(c);
    }
}
