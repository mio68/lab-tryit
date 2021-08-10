package mio68.lab.tryit.codewars;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Kata {

    public static String createPhoneNumber(int[] numbers) {
        return createPhoneNumber5(numbers);
    }

    public static String createPhoneNumber1(int[] n) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", n[0], n[1], n[2], n[3], n[4], n[5], n[6], n[7], n[8], n[9]);
    }

    public static String createPhoneNumber2(int[] numbers) {
        String phoneDigits = Arrays.toString(numbers).replaceAll("\\D","");

        return "(" + phoneDigits.substring(0,3) + ") "
                + phoneDigits.substring(3,6) + "-"
                + phoneDigits.substring(6);
    }

    public static String createPhoneNumber3(int[] numbers) {
        String phoneDigits = Arrays.toString(numbers).replaceAll("\\D","");

        return String.format("(%s) %s-%s"
                ,phoneDigits.substring(0,3)
                ,phoneDigits.substring(3,6)
                ,phoneDigits.substring(6));
    }

    public static String createPhoneNumber4(int[] numbers) {
        String phoneDigits = Arrays.toString(numbers).replaceAll("\\D","");
        Matcher m = Pattern.compile("(\\d{3})(\\d{3})(\\d{4})").matcher(phoneDigits);
        m.find();
        return String.format("(%s) %s-%s" ,m.group(1) , m.group(2), m.group(3));
    }

    public static String createPhoneNumber5(int[] numbers) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", IntStream.of(numbers).boxed().toArray());
    }
}