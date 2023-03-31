package mio68.lab.tryit.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LookBehindAndAhead {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(?<=cert=)[^;]+");
        String s = "hash=abcd1234; cert= --BEGIN 12345 \nEND---; mode=A";
        Matcher matcher = pattern.matcher(s);
        System.out.println(matcher.find());
        System.out.printf("[%s]%n", matcher.group());
    }

}
