package mio68.lab.tryit.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathEvaluatorTest {
    @Test
    public void testAddition() {
        assertEquals(2d, new MathEvaluator().calculate("1+1"),  0.01);
    }

    @Test public void testSubtraction() {
        assertEquals(0d, new MathEvaluator().calculate("1 - 1"),  0.01);
    }

    @Test public void testAdditionSubtractionExpression() {
        assertEquals(9.73d, new MathEvaluator().calculate("1 - 1 + -0.5 -0.5 + 10.73"),  0.01);
    }


    @Test public void testMultiplication() {
        assertEquals(new MathEvaluator().calculate("1* 1"), 1d, 0.01);
    }

    @Test public void testDivision() {
        assertEquals(new MathEvaluator().calculate("1 /1"), 1d, 0.01);
    }

    @Test public void testNegative() {
        assertEquals(new MathEvaluator().calculate("-123"), -123d, 0.01);
    }

    @Test public void testLiteral() {
        assertEquals(new MathEvaluator().calculate("123"), 123d, 0.01);
    }

    @Test public void testExpression() {
        assertEquals(new MathEvaluator().calculate("2 /2+3 * 4.75- -6"), 21.25, 0.01);
    }

    @Test public void testSimple() {
        assertEquals(new MathEvaluator().calculate("12* 123"), 1476d, 0.01);
    }

    @Test public void testComplex() {
        assertEquals(new MathEvaluator().calculate("2 / (2 + 3) * 4.33 - -6"), 7.732, 0.01);
    }
}