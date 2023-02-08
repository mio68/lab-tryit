package mio68.lab.tryit.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseTokenSequenceWithNamedGropus {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(?<ab>ab\\d)|(?<cd>cd\\d)|(?<space>\\s+)");
        String expression = "ab1 cd3  ab2 cd5 cd7";
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            System.out.printf(
                    "token: ab:[%s] cd:[%s] space:[%s]%n",
                    matcher.group("ab"),
                    matcher.group("cd"),
                    matcher.group("space"));
        }
    }

}
