package mio68.lab.tryit.codewars.simplexer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Simplexer implements Iterator<Token> {

    private static final Pattern PATTERN = Pattern.compile(
            "(?<integer>\\d+)"
                    + "|(?<boolean>true|false)"
                    + "|(?<string>\".+\")"
                    + "|(?<operator>[-+*/%()=])"
                    + "|(?<keyword>if|else|for|while|return|func|break)"
                    + "|(?<whitespace>\\s+)"
                    + "|(?<identifier>[a-zA-Z_$][a-zA-Z0-9_$]*)"
    );

    private static final List<String> TOKEN_TYPES = List.of(
            "integer", "boolean", "string", "operator",
            "keyword", "whitespace", "identifier");

    private final Iterator<Token> iterator;

    public Simplexer(String buffer) {
        if (buffer == null) {
            iterator = Collections.emptyIterator();
        } else {
            Matcher matcher = PATTERN.matcher(buffer);
            List<Token> tokens = new ArrayList<>();
            while (matcher.find()) {
                tokens.add(createToken(matcher));
            }
            iterator = tokens.iterator();
        }
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Token next() {
        return iterator.next();
    }

    private Token createToken(Matcher matcher) {
        return TOKEN_TYPES.stream()
                .filter(tokenType -> matcher.group(tokenType) != null)
                .map(tokenType -> new Token(matcher.group(tokenType), tokenType))
                .findAny()
                .orElseThrow();
    }

}