package mio68.lab.tryit.codewars;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runes {

    public static int solveExpression(final String expression) {

        Matcher matcher = Pattern.compile("(-?[0-9?]{1,7})([*+-])(-?[0-9?]{1,7})=(-?[0-9?]{1,7})")
                .matcher(expression);

        if (!matcher.matches()) {
            return -1;
        }

        String tokenA = matcher.group(1);
        String operatorToken = matcher.group(2);
        String tokenB = matcher.group(3);
        String resultToken = matcher.group(4);
        int startCandidateDigit = isLeadingZeroToken(tokenA)
                || isLeadingZeroToken(tokenB)
                || isLeadingZeroToken(resultToken) ? 1 : 0;

        for (int candidateDigit = startCandidateDigit; candidateDigit < 10; candidateDigit++) {

            if (expression.contains(String.valueOf(candidateDigit))) {
                continue;
            }

            long operandA = applyDigit(tokenA, candidateDigit);
            long operandB = applyDigit(tokenB, candidateDigit);
            long result = applyDigit(resultToken, candidateDigit);

            if (isCorrectExpression(operandA, operatorToken, operandB, result)) {
                return candidateDigit;
            }
        }

        return -1;
    }

    private static boolean isLeadingZeroToken(String token) {
        return (token.startsWith("?") && token.length() > 1)
                || (token.startsWith("-?") && token.length() > 2);
    }

    private static long applyDigit(String token, int digit) {
        return Long.parseLong(token.replaceAll("\\?", String.valueOf(digit)));
    }

    private static boolean isCorrectExpression(long operandA, String operator, long operandB, long result) {

        long actualResult = switch (operator) {
            case "+" -> operandA + operandB;
            case "-" -> operandA - operandB;
            case "*" -> operandA * operandB;
            default -> throw new IllegalArgumentException(String.format("Operation [%s] is not supported.", operator));
        };

        return actualResult == result;
    }

}
