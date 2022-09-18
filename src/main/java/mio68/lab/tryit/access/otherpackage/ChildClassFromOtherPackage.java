package mio68.lab.tryit.access.otherpackage;

import mio68.lab.tryit.access.ChildClass;
import mio68.lab.tryit.access.ParentClass;

public class ChildClassFromOtherPackage extends ParentClass {

    private int privateFieldOfChildClass = 0;
    int packagePrivateFieldOfChildClass = 1;
    protected int protectedFieldOfChildClass = 2;

    void packagePrivateMethodOfChildClass() {
        System.out.println("ChildClass.packagePrivateMethodOfChildClass()");
    }

    protected void protectedMethodOfChildClass() {
        System.out.println("ChildClass.protectedMethodOfChildClass()");
    }

    private void privateMethodOfChildClass() {
        System.out.println("ChildClass.privateMethodOfChildClass()");
    }

    // Access to inherited members (inherited member are with protected access modifier)
    public void method() {
        int r;
        // access to inherited package-private field IS PROHIBITED!
//        r = packagePrivateFieldOfParentClass;

        // access to inherited package-private method IS PROHIBITED!
//        packagePrivateMethodOfParentClass();

        // access to inherited protected field is allowed.
        r = protectedFieldOfParentClass;

        // access to inherited protected method is allowed.
        protectedMethodOfParentClass();

    }

    // Access to members of an instance of parent class
    // ONLY PUBLIC MEMBERS ARE ACCESSIBLE!!!
    public void method(ParentClass instanceOfParentClass) {
        int r;

        // access to package-private field of an instance of parent class
        // PROHIBITED!
//        r = instanceOfParentClass.packagePrivateFieldOfParentClass;

        // access to package-private method of an instance of parent class
        // PROHIBITED!
//        instanceOfParentClass.packagePrivateMethodOfParentClass();

        // access to protected field of an instance of parent class
        // NO ACCESS!!!
//        r = instanceOfParentClass.protectedFieldOfParentClass;

        // access to protected method of an instance of parent class
        // NO ACCESS!!!
//        instanceOfParentClass.protectedMethodOfParentClass();

    }

    // Access to members of an instance of this class
    public void method(ChildClassFromOtherPackage instanceOfThisClass) {
        int r;

        // access to package-private field of an instance of this class
//NO ACCESS!  r = instanceOfThisClass.packagePrivateFieldOfParentClass;
        r = instanceOfThisClass.packagePrivateFieldOfChildClass;

        // access to package-private method of an instance of this class
//NO ACCESS!        instanceOfThisClass.packagePrivateMethodOfParentClass();
        instanceOfThisClass.packagePrivateMethodOfChildClass();

        // access to protected field of an instance of this class
        r = instanceOfThisClass.protectedFieldOfParentClass;
// NO ACCESS  r = ((ParentClass) instanceOfThisClass).protectedFieldOfParentClass;
        r = instanceOfThisClass.protectedFieldOfChildClass;

        // access to protected method of an instance of this class
        instanceOfThisClass.protectedMethodOfParentClass();
        instanceOfThisClass.protectedMethodOfChildClass();

    }

    // Access to members of an instance of other child of parent class
    // ONLY PUBLIC MEMBERS ARE ACCESSIBLE!!!
    public void method(ChildClass instanceOfChildClass) {
        int r;

        // access to package-private field of an instance of other child of parent class
        // PROHIBITED!
//        r = instanceOfChildClass.packagePrivateFieldOfParentClass;

        // access to package-private method of an instance of other child of parent class
        // PROHIBITED!
//        instanceOfChildClass.packagePrivateMethodOfParentClass();

        // access to protected field of an instance of other child of parent class
        // NO ACCESS!!!
//        r = instanceOfChildClass.protectedFieldOfParentClass;

        // access to protected method of an instance of other child of parent class
        // NO ACCESS!!!
//        instanceOfChildClass.protectedMethodOfParentClass();

    }


}
