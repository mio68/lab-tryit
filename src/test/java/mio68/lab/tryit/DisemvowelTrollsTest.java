package mio68.lab.tryit;

import mio68.lab.tryit.codewars.DisemvowelTrolls;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisemvowelTrollsTest {
    public static final String inputString = "This website is for losers LOL!";
    public static final String resultString = "Ths wbst s fr lsrs LL!";

    @Test
    void disemvowel() {
        assertEquals(resultString, DisemvowelTrolls.disemvowel(inputString));
    }

    @Test
    void disemvowel2() {
        assertEquals(resultString, DisemvowelTrolls.disemvowel2(inputString));
    }
}