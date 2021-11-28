package mio68.lab.tryit.codewars;


import mio68.lab.tryit.codewars.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    @Test
    public void sampleTest() {
        // assertEquals("expected", "actual");
        assertTrue(Solution.validParentheses("()"));
        assertFalse(Solution.validParentheses("())"));
        assertTrue(Solution.validParentheses("32423(sgsdg)"));
        assertFalse(Solution.validParentheses("(dsgdsg))2432"));
        assertTrue(Solution.validParentheses("adasdasfa"));
    }
}
