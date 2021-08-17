package mio68.lab.tryit.codewars;

public class Solution {

    public static boolean validParentheses(String parens) {
        return validParentheses3(parens);
    }

    public static boolean validParentheses1(String parens) {
        return parens.chars()
                .filter(c -> c == '(' || c == ')')
                .map(c -> c == '(' ? 1 : -1)
                .reduce(0, (c1, c2) -> c1 < 0 ? c1 : c1 + c2) == 0;
    }

    // Java 12 only!
    public static boolean validParentheses2(String parens) {
        return parens.chars()
                .map(c -> switch (c) {
                    case '(' -> 1;
                    case ')' -> -1;
                    default -> 0;
                })
                .reduce(0, (c1, c2) -> c1 < 0 ? c1 : c1 + c2) == 0;
    }

    public static boolean validParentheses3(String parens) {
        return parens.replaceAll("[^()]","").chars()
                .map(c -> c == '(' ? 1 : -1)
                .reduce(0, (c1, c2) -> c1 < 0 ? c1 : c1 + c2) == 0;
    }

}