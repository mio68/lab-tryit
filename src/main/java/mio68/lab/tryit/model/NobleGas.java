package mio68.lab.tryit.model;

public enum NobleGas {

    HELIUM(2),
    NEON(10),
// If element of enum is removed than client class that still uses it will throw at runtime:
// Exception in thread "main" java.lang.NoSuchFieldError: ARGON
    ARGON(18),
    KRYPTON(36),
    XENON(54),
    RADON(86);

    private static final String stringConstant = "This is string constant!";
    private static int anStaticIntField = 12345;

    private final int atomicNumber;

    NobleGas(int atomicNumber) {
        this.atomicNumber = atomicNumber;

        // it's Ok!
//      System.out.println(stringConstant);

        // It's illegal to access static member form enum constructor of instance initializer
//        System.out.println(anStaticIntField);
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public static void main(String[] args) {

    }
}
