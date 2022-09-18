package mio68.lab.tryit.access;

public class ParentClass {

    private int privateFieldOfParentClass = 0;
    int packagePrivateFieldOfParentClass = 1;
    protected int protectedFieldOfParentClass = 2;

    void packagePrivateMethodOfParentClass() {
        System.out.println("ParentClass.packagePrivateMethodOfParentClass()");
    }

    protected void protectedMethodOfParentClass() {
        System.out.println("ParentClass.protectedMethodOfParentClass()");
    }

    private void privateMethodOfParentClass() {
        System.out.println("ParentClass.privateMethodOfParentClass()");
    }
}
