package mio68.lab.tryit.operator;

public class Plus {
    public static void main(String[] args) {
        byte b = 1;

        // Compilation error because of binary promotion
        // java: incompatible types: possible lossy conversion from int to byte
        // cast required! b = (byte) (b + 1);
        // b = b + 1;

        b += 1; // It's ok. Because it casts to byte implicitly. It s equivalent to b = (byte) (b + 1);

        b++; // Just ok too!

    }
}
