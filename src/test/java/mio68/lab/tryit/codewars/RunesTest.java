package mio68.lab.tryit.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunesTest {

    @Test
    public void testSample() {
        assertEquals(2, Runes.solveExpression("1+1=?"), "Answer for expression '1+1=?' ");
        assertEquals(6, Runes.solveExpression("123*45?=5?088"), "Answer for expression '123*45?=5?088' ");
        assertEquals(0, Runes.solveExpression("-5?*-1=5?"), "Answer for expression '-5?*-1=5?' ");
        assertEquals(-1, Runes.solveExpression("19--45=5?"), "Answer for expression '19--45=5?' ");
        assertEquals(5, Runes.solveExpression("??*??=302?"), "Answer for expression '??*??=302?' ");
        assertEquals(2, Runes.solveExpression("?*11=??"), "Answer for expression '?*11=??' ");
        assertEquals(2, Runes.solveExpression("??*1=??"), "Answer for expression '??*1=??' ");
        assertEquals(-1, Runes.solveExpression("??+??=??"), "Answer for expression '??+??=??' ");
    }

}