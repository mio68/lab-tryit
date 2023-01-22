package mio68.lab.tryit.codewars;

import java.util.stream.Collectors;

// https://www.codewars.com/kata/51c8e37cee245da6b40000bd/train/java
public class StripComments {

    public static String stripComments1(String text, String[] commentSymbols) {
        String commentStartsWith = String.join("", commentSymbols);

        return text.lines()
                .map(s -> s.replaceAll("[" + commentStartsWith + "].*", "").stripTrailing())
                .collect(Collectors.joining("\n"));
    }

    public static String stripComments(String text, String[] commentSymbols) {
        return text.replaceAll("[ ]*([" + String.join("", commentSymbols) + "].*)?(\n|$)", "$2");
    }
}
