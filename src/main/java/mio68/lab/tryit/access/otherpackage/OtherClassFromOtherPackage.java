package mio68.lab.tryit.access.otherpackage;

import mio68.lab.tryit.access.ParentClass;

public class OtherClassFromOtherPackage {

    // Other class from other package -
    // NO ACCESS to package-private and protected
    // members of an instance of a class from other package.
    // NO ACCESS to private members of an instance of a class of course.
    // If there is no relations between this classed when
    // ONLY PUBLIC members of an instance of a class are accessible.
    static void method(ParentClass parentClass) {
//        System.out.println(
//                "parentClass.packagePrivateFieldOfParentClass = " +
//                parentClass.packagePrivateFieldOfParentClass
//        );
//
//        parentClass.packagePrivateMethodOfParentClass();
//
//        System.out.println(
//                "parentClass.protectedFieldOfParentClass = " +
//                parentClass.protectedFieldOfParentClass
//        );
//
//        parentClass.protectedMethodOfParentClass();
//

    }

    public static void main(String[] args) {
        method(new ParentClass());
    }
}
