package mio68.lab.tryit.access.otherpackage;

import mio68.lab.tryit.access.ChildClass;
import mio68.lab.tryit.access.ParentClass;
import mio68.lab.tryit.access.thirdpackage.ChildOfAChild;

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
    private void accessToInheritedMembers() {
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
    private void doSomethingWithParentInstance(ParentClass instanceOfParentClass) {
        int r;

        // access to package-private field of an instance of parent class
        // PROHIBITED!
//        r = instanceOfParentClass.packagePrivateFieldOfParentClass;

        // access to package-private method of an instance of parent class
        // PROHIBITED!
//        instanceOfParentClass.packagePrivateMethodOfParentClass();

        // access to protected field of an instance of parent class
        // This field is not inherited!!!
        // NO ACCESS!!!
//        r = instanceOfParentClass.protectedFieldOfParentClass;

        // access to protected method of an instance of parent class
        // NO ACCESS!!!
//        instanceOfParentClass.protectedMethodOfParentClass();

    }

    // Access to members of an instance of this class
    private void doSomethingWithThisClassInstance(ChildClassFromOtherPackage instanceOfThisClass) {
        int r;

        // access even to private field of course!
        r = instanceOfThisClass.privateFieldOfChildClass;

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
    private void doSomethingWithBrotherFromAnotherPackage(ChildClass instanceOfChildClass) {
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

    private void doSomethingWithChild(ChildOfAChild child) {
        // Have access to inherited fields
        int fromParent = child.protectedFieldOfParentClass; //parent field
        int ownField = child.protectedFieldOfChildClass; //own field

        // Have access to inherited methods
        child.protectedMethodOfParentClass(); // parent method
        child.protectedMethodOfChildClass();  // own method

        // no access to non-public members of child!
    }

}
