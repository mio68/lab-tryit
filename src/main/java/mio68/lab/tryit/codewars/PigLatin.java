package mio68.lab.tryit.codewars;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PigLatin {

    public static String pigIt(String str) {
        return pigIt2(str);
    }


    public static String pigIt1(String str) {
        StringBuilder sb = new StringBuilder();

        for (String w: str.split("\\b"))
            if(w.matches("[a-zA-z]+"))
                sb.append(w.substring(1)).append(w.charAt(0)).append("ay");
            else
                sb.append(w);

        return sb.toString();
    }

    public static String pigIt2(String str) {
        return Pattern.compile("(\\w)(\\w*)").matcher(str).replaceAll("$2$1ay");
    }

}