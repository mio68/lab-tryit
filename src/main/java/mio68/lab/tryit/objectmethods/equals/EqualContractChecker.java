package mio68.lab.tryit.objectmethods.equals;

import java.util.stream.Stream;

public class EqualContractChecker {

    private EqualContractChecker() {

    }

    public static void printEqualContractInfo(Object o1, Object o2, Object o3) {

        printReflectionInfo(o1);

        printSymmetryInfo(o1, o2);

        printTransitivityInfo(o1, o2, o3);

    }

    private static void printTransitivityInfo(Object o1, Object o2, Object o3) {
        System.out.println("Transitivity:\n\to1.equals(o2):" + o1.equals(o2) +
                "\n\to2.equals(o3): " + o2.equals(o3) +
                "\n\to1.equals(o3): " + o1.equals(o3));

        long trueCount = Stream
                .of(
                        o1.equals(o2),
                        o2.equals(o3),
                        o1.equals(o3))
                .filter(aBoolean -> aBoolean)
                .count();


        if (trueCount == 3) {
            System.out.println("\ttransitivity is ok.");
        } else if (trueCount == 2) {
            System.out.println("\ttransitivity is broken.");
        } else {
            System.out.println("\ttransitivity status is undefined.");
        }
    }

    private static void printSymmetryInfo(Object o1, Object o2) {
        System.out.println("Symmetry:\n\to1.equals(o2):" + o1.equals(o2) + "\n\to2.equals(o1): " + o2.equals(o1));

        long trueCount = Stream
                .of(
                        o1.equals(o2),
                        o2.equals(o1))
                .filter(aBoolean -> aBoolean)
                .count();

        if (trueCount == 2) {
            System.out.println("\tsymmetry is ok.");
        } else if (trueCount == 1) {
            System.out.println("\tsymmetry is broken!");
        } else {
            System.out.println("\tsymmetry is undefined.");
        }
    }

    private static void printReflectionInfo(Object o1) {
        System.out.println("Reflection:\n\to1.equals(o1):" + o1.equals(o1));
        if (o1.equals(o1)) {
            System.out.println("\treflection is ok.");
        } else {
            System.out.println("\treflection is broken!");
        }
    }

}
