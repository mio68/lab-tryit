package mio68.lab.tryit.interfaces;

interface A {
    void m();
}

interface B {
    default void m() {
        System.out.println("B");
    }
}

//Compilation Error
//java: types mio68.lab.tryit.interfaces.B and mio68.lab.tryit.interfaces.A are incompatible;
//interface mio68.lab.tryit.interfaces.C inherits abstract and default for m() from types mio68.lab.tryit.interfaces.B and mio68.lab.tryit.interfaces.A
//
//interface C extends A,B {
//
//}

public class PreventInheritanceForDefaultAndAbstract {
}
