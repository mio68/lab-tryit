package mio68.lab.tryit.operator;

import mio68.lab.tryit.mix.question10.p2.B;

public class EqualityForBoolean {

    public static void main(String[] args) {
        System.out.println(new Boolean(true) == Boolean.TRUE); // false, reference equality
        System.out.println(new Boolean("TRUE") == true); // true, boolean equality
        System.out.println(new Boolean("true") == new Boolean(true)); // false, reference equality
        System.out.println(Boolean.TRUE.equals(new Boolean("trUE"))); // true, equals is overriden
        System.out.println(new Boolean(true) == new Boolean(true)); // false, reference equality
        System.out.println(new Boolean(Boolean.TRUE) == Boolean.TRUE); //false, reference equality
        System.out.println(new Boolean("TRUE").equals(true)); //true, equals overriden and chec values
    }

}
