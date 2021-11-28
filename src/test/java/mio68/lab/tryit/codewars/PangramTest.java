package mio68.lab.tryit.codewars;

import mio68.lab.tryit.codewars.PangramChecker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PangramTest {
    @Test
    public void test1() {
        String pangram1 = "The quick brown fox jumps over the lazy dog.";
        PangramChecker pc = new PangramChecker();
        assertTrue(pc.check(pangram1));
    }
    @Test
    public void test2() {
        String pangram2 = "You shall not pass!";
        PangramChecker pc = new PangramChecker();
        assertFalse(pc.check(pangram2));
    }
}