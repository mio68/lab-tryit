package mio68.lab.tryit.nested;

public class OuterWithLocal {

    public void methodThatUsesLocalClass(int intParam) {
        int localInt = 0;
        final int finalLocalInt = 0;

        class LocalClass {
            static int totalSum = 0; // Strange! It defines static member.
            void methodUsesLocalVars() {
                int sum = 0;
//                sum += localInt; //Compilation error: local variable needs to be final
                sum += finalLocalInt; //It's ok!
                sum += intParam;
                totalSum += sum;
            }
        }

        LocalClass lc = new LocalClass();
        lc.methodUsesLocalVars();
        System.out.println(LocalClass.totalSum); //Hm...

        localInt = 1;

        LocalClass lc1 = new LocalClass();
        lc1.methodUsesLocalVars();
        System.out.println(LocalClass.totalSum); //Hm...

    }

    void methodLocalInterfacesAreNotAllowedReally() {
        interface LocalInterface {
            void doIt();
        }

        class LocalClass implements LocalInterface {

            @Override
            public void doIt() {

            }
        }

        LocalInterface localInterface = new LocalClass();
        localInterface.doIt();
    }

    void methodWitLocalClassWithStaticMethod() {
        class LocalClass {
            static void doIt() {

            }
        }

        LocalClass.doIt();
    }



    public static void main(String[] args) {
        OuterWithLocal outerWithLocal = new OuterWithLocal();
        outerWithLocal.methodThatUsesLocalClass(1);
        outerWithLocal.methodLocalInterfacesAreNotAllowedReally();
        outerWithLocal.methodWitLocalClassWithStaticMethod();
    }
}
