package mio68.lab.tryit.codewars.simplexer;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SimplexerTest {

    @Test
    public void testEmpty() {
        Simplexer lexer = new Simplexer("");
        assertFalse(lexer.hasNext());
    }

    @Test
    public void testSingle() {
        // Identifier
        Simplexer lexer = new Simplexer("x");
        assertTrue(lexer.hasNext());
        assertEquals(new Token("x", "identifier"), lexer.next());

        // Boolean
        lexer = new Simplexer("true");
        assertTrue(lexer.hasNext());
        assertEquals(new Token("true", "boolean"), lexer.next());

        // Integer
        lexer = new Simplexer("12345");
        assertTrue(lexer.hasNext());
        assertEquals(new Token("12345", "integer"), lexer.next());

        // String
        lexer = new Simplexer("\"Hello\"");
        assertTrue(lexer.hasNext());
        assertEquals(new Token("\"Hello\"", "string"), lexer.next());

        // Keyword
        lexer = new Simplexer("break");
        assertTrue(lexer.hasNext());
        assertEquals(new Token("break", "keyword"), lexer.next());
    }

    @Test
    public void testExpression() {
        // Simple expression
        Simplexer lexer = new Simplexer("(1 + 2) - 5");
        assertEquals(Arrays.asList(new Token("(", "operator"),
                new Token("1", "integer"),
                new Token(" ", "whitespace"),
                new Token("+", "operator"),
                new Token(" ", "whitespace"),
                new Token("2", "integer"),
                new Token(")", "operator"),
                new Token(" ", "whitespace"),
                new Token("-", "operator"),
                new Token(" ", "whitespace"),
                new Token("5", "integer")), toList(lexer));
    }

    @Test
    public void testStatement() {
        // Simple statement.
        Simplexer lexer = new Simplexer("return x + 1");
        assertEquals(Arrays.asList(new Token("return", "keyword"),
                new Token(" ", "whitespace"),
                new Token("x", "identifier"),
                new Token(" ", "whitespace"),
                new Token("+", "operator"),
                new Token(" ", "whitespace"),
                new Token("1", "integer")), toList(lexer));
    }

    private List<Token> toList(Simplexer lexer) {
        List<Token> tokens = new ArrayList<>();
        lexer.forEachRemaining(tokens::add);
        return tokens;
    }

}
