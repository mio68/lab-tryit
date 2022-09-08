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

    private final int atomicNumber;

    NobleGas(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }
}
