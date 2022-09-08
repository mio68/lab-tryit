package mio68.lab.tryit.lang;

import mio68.lab.tryit.model.NobleGas;

// It's impossible to extend an enum.
// Compilation error: java: '{' expected
// IntelliJ IDEA says: Cannot inherit from enum
//  public enum ExtendedNobelGas extends NobleGas {
//      OGANESSON(118)
//  }

class ExtendedNobleGas {
    NobleGas nobleGas;


    public static void main(String[] args) {

        // IntelliJ IDEA says: Enum types cannot be instantiated.
        // Compilation error: java: enum types may not be instantiated
        // NobleGas gas = new NobleGas(118);
    }

}