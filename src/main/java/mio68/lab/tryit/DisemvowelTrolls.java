package mio68.lab.tryit;

public class DisemvowelTrolls {
 /**These letters are vowels in English:
    A, E, I, O, U, and sometimes Y.
  */
    public static final String vowels = "aeiouAEIOU";

    public static String disemvowel(String str) {
        return String.join("", str.split("[aeiouAEIOU]"));
    }

    public static String disemvowel2(String str) {
        return str.replaceAll("[aeiouAEIOU]","");
    }
}
