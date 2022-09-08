package mio68.lab.tryit.model;

public enum NobleGas {

    HELIUM(2),
    NEON(10),
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
