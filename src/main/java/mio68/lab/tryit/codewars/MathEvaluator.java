package mio68.lab.tryit.codewars;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathEvaluator {




    public double calculate(String expression) {

        Pattern exp = Pattern.compile("(?<T1>[^+-]+)");


        expression = expression.replaceAll("\\s+", "");
        return calculateSumWithoutBrackets(expression);
    }


    private double calculateSumWithoutBrackets(String exp) {
        Pattern pattern = Pattern.compile("\\G(?<num>-?((\\.\\d+)|(\\d+\\.\\d+)|(\\d+)))(?<op>[+-])?");

        Matcher matcher = pattern.matcher(exp);
        if (!matcher.find()) {
            throw new IllegalArgumentException(String.format("Invalid expression [%s]", exp));
        }

        Double result = Double.parseDouble(matcher.group("num"));

        String op;
        while ((op = matcher.group("op")) != null) {
            int position = matcher.end();
            if (!matcher.find()) {
                throw new IllegalArgumentException(
                        String.format("Number expected [%s]", exp.substring(position)));
            }
            Double operand = Double.parseDouble(matcher.group("num"));
            switch (op) {
                case "+" -> result += operand;
                case "-" -> result -= operand;
                default -> throw new IllegalArgumentException(
                        String.format("Unsupported operation [%]", op));
            }
        }

        return result;
    }

    private double calculateProd(String exp) {
        return 0;
    }

}