package mio68.lab.tryit.mix;

import java.util.function.IntBinaryOperator;

/**
 * There is way to control auto box cache size.
 * -XX:AutoBoxCacheMax=<size>
 *  default is 127
 */
public class IntegerIdentities {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 1;

        Integer c = 128;
        Integer d = 128;

        System.out.println(a == b); // true - a and b are the same identity, because of caching
        System.out.println(c == d); // false
    }

}
