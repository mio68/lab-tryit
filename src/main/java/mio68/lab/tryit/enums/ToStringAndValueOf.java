package mio68.lab.tryit.enums;

import mio68.lab.tryit.model.NobleGas;

import java.util.Arrays;

public class ToStringAndValueOf {

    public static void main(String[] args) {
        NobleGas nobleGas = NobleGas.ARGON;
        System.out.println(nobleGas); // prints just ARGON. doesn't print atomic number
        System.out.println(NobleGas.ARGON.getAtomicNumber()); // 18
        System.out.println(NobleGas.ARGON.ordinal()); //2

        nobleGas = NobleGas.valueOf("NEON");
        System.out.println(nobleGas); // NEON

        System.out.println(Arrays.toString(NobleGas.values())); // [HELIUM, NEON, ARGON, KRYPTON, XENON, RADON]
    }
}
