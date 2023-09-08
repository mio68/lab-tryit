package mio68.lab.tryit.math;

import java.math.BigDecimal;

public class BigDecimalDemo {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("0.10");
        System.out.println(bigDecimal); // 0.10
        System.out.println(bigDecimal.scale());
        System.out.println(bigDecimal.precision()); // 2

        BigDecimal bigDecimal1 = new BigDecimal("0.1");
        System.out.println(bigDecimal1);                    // 0.1
        System.out.println(bigDecimal1.precision());        // 1

        System.out.println(bigDecimal.subtract(bigDecimal1)); // 0.00

        System.out.println(bigDecimal.equals(bigDecimal1)); // false
        System.out.println(bigDecimal.compareTo(bigDecimal1)); // 0
        System.out.println(bigDecimal.compareTo(bigDecimal1) == 0); // test for value equality
    }

}
