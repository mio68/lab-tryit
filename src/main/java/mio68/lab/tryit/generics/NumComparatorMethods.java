package mio68.lab.tryit.generics;

public class NumComparatorMethods {

//    static <T extends Number> int compare_1(T a, T b) {
//        return a.compareTo(b); //Number is not comparable
//    }

    static <T extends Number & Comparable<? super T>> int compare_2(T a, T b) {
        return a.compareTo(b);
    }

    static <T extends Number & Comparable<T>> int compare_3(T a, T b) {
        return a.compareTo(b);
    }

//    To specify additional interfaces that must be implemented, use the & character, as in:
//    <U extends Number & MyInterface>

    // interface expected
//    static <T extends Comparable<T> & Number> int compare_4(T a, T b) {
//        return a.compareTo(b);
//    }

    public static void main(String[] args) {
        Integer i = 1, j = 2;
        Double d = 0.1D, e = 0.2D;
        System.out.println(compare_2(i, j));
        System.out.println(compare_3(i, j));

        System.out.println(compare_2(d, e));
        System.out.println(compare_3(d, e));


    }
}
