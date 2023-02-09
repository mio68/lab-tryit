package mio68.lab.tryit.codewars.simplexer;

import java.util.Objects;

public class Token {
    private final String text;
    private final String type;

    public Token(String text, String type) {
        this.text = text;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return Objects.equals(text, token.text) && Objects.equals(type, token.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, type);
    }
}
