package mio68.lab.tryit.access;

public class OtherClassFromSamePackage {

    // Other class from same package get access to package-private and protected
    // members of an instance from same package.
    // NO ACCESS to private members of course.
    static void method(ParentClass parentClass) {
        // access to package-private field of an instance of a class from same package
        System.out.println(
                "parentClass.packagePrivateFieldOfParentClass = " +
                parentClass.packagePrivateFieldOfParentClass
        );

        // access to package-private method of an instance of a class from same package
        parentClass.packagePrivateMethodOfParentClass();

        // access to protected field of an instance of a class from same package
        System.out.println(
                "parentClass.protectedFieldOfParentClass = " +
                parentClass.protectedFieldOfParentClass
        );

        // access to protected method of an instance of a class from same package
        parentClass.protectedMethodOfParentClass();

    }

    public static void main(String[] args) {
        method(new ParentClass());
    }
}
