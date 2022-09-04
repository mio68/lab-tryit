package mio68.lab.tryit.math;

import org.junit.jupiter.api.Test;

import static mio68.lab.tryit.math.Gcd.gcd;
import static org.junit.jupiter.api.Assertions.*;

class GcdTest {

    @Test
    public void whenBothArgumentsIsZero_thenTrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> gcd(0, 0));
    }

    @Test
    public void gcdOfTwoIntegers() {
        assertAll("gcd of two arguments",
                () -> assertEquals(3, gcd(3,0)),
                () -> assertEquals(3, gcd(0,3)),
                () -> assertEquals(1, gcd(1,1)),
                () -> assertEquals(1, gcd(1,5)),
                () -> assertEquals(1, gcd(5,1)),
                () -> assertEquals(7, gcd(7,7)),
                () -> assertEquals(6, gcd(54,24)),
                () -> assertEquals(6, gcd(24,54)),
                () -> assertEquals(12, gcd(180,48)),
                () -> assertEquals(6, gcd(18,48))
                );
    }

    @Test
    public void gcdOfManyArguments() {
        assertAll("gcd of many arguments",
                () -> assertEquals(3, gcd(3,0, 3)),
                () -> assertEquals(3, gcd(0,3, 3)),
                () -> assertEquals(1, gcd(1,1, 1)),
                () -> assertEquals(1, gcd(1,5, 3)),
                () -> assertEquals(1, gcd(5,1, 3)),
                () -> assertEquals(7, gcd(7,7,7)),
                () -> assertEquals(3, gcd(54,24, 9)),
                () -> assertEquals(6, gcd(24,54, 12, 18)),
                () -> assertEquals(6, gcd(180,48, 18, 24, 60)),
                () -> assertEquals(6, gcd(18,48, 36, 600, 42, 12, 6))
        );
    }

}