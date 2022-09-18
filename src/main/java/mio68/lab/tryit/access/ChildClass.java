package mio68.lab.tryit.access;

public class ChildClass extends ParentClass {

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

    // Access to inherited members
    public void method() {
        // access to inherited package-private field
        System.out.println(
                "access from ChildClass to inherited packagePrivateFieldOfParentClass : "
                        + packagePrivateFieldOfParentClass);

        // access to inherited package-private method
        System.out.println("access from ChildClass to inherited packagePrivateMethodOfParentClass()");
        packagePrivateMethodOfParentClass();

        // access to inherited protected field
        System.out.println(
                "access from ChildClass to inherited protectedFieldOfParentClass : "
                        + protectedFieldOfParentClass);

        // access to inherited protected method
        System.out.println("access from ChildClass to inherited protectedMethodOfParentClass()");
        protectedMethodOfParentClass();

    }

    // Access to members of an instance of parent class
    public void method(ParentClass instanceOfParentClass) {
        int r;

        // access to package-private field of an instance of parent class
        r = instanceOfParentClass.packagePrivateFieldOfParentClass;

        // access to package-private method of an instance of parent class
        instanceOfParentClass.packagePrivateMethodOfParentClass();

        // access to protected field of an instance of parent class
        r = instanceOfParentClass.protectedFieldOfParentClass;

        // access to protected method of an instance of parent class
        instanceOfParentClass.protectedMethodOfParentClass();

    }

    // Access to members of an instance of this class
    public void method(ChildClass instanceOfThisClass) {
        int r;

        // access to package-private field of an instance of this class
        r = instanceOfThisClass.packagePrivateFieldOfParentClass;
        r = instanceOfThisClass.packagePrivateFieldOfChildClass;

        // access to package-private method of an instance of this class
        instanceOfThisClass.packagePrivateMethodOfParentClass();
        instanceOfThisClass.packagePrivateMethodOfChildClass();

        // access to protected field of an instance of this class
        r = instanceOfThisClass.protectedFieldOfParentClass;
        r = instanceOfThisClass.protectedFieldOfChildClass;

        // access to protected method of an instance of this class
        instanceOfThisClass.protectedMethodOfParentClass();
        instanceOfThisClass.protectedMethodOfChildClass();

    }

}
