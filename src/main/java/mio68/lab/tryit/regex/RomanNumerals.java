package mio68.lab.tryit.regex;

import java.util.regex.Pattern;

public class RomanNumerals {

    // Remember that Pattern is thread safe, but Matcher is not.
    private static final Pattern ROMAN = Pattern.compile("^(M*C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    public static boolean isValidRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }
}
