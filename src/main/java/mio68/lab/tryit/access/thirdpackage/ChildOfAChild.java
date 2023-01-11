package mio68.lab.tryit.access.thirdpackage;

import mio68.lab.tryit.access.ParentClass;
import mio68.lab.tryit.access.otherpackage.ChildClassFromOtherPackage;

public class ChildOfAChild extends ChildClassFromOtherPackage {

    protected int protectedField = 1;

    private void accessInheritedMembers() {
        int fromGrandParent = this.protectedFieldOfParentClass;
        int fromParent = this.protectedFieldOfChildClass;

        // Call method of grandparent.
        protectedMethodOfParentClass();

        // Call method of parent.
        protectedMethodOfChildClass();
    }


    private void doSomethingWithGrandParentInstance(ParentClass grandParent) {
        // No access to non-public members of grandparent.
        // Fields and methods are not inherited!
    }

    private void doSomethingWithParentInstance(ChildClassFromOtherPackage parent) {
        // No access to non-public members of grandparent.
        // Fields and methods are not inherited!
    }

    protected void protectedMethod() {

    }
}
