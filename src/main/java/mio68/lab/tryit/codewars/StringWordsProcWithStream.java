package mio68.lab.tryit.codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringWordsProcWithStream {
    public static void main(String[] args) {
        String s7 = "one two three five six seven";
        String one = "one";
        String three = "three";
        String emptyString = "";
        String s = s7;

        //without Stream
        long t1 = System.currentTimeMillis();
        String convertedString = "";
        String[] words = s.split(" ");
        for (String wrd : words) {
            if( wrd.length() > 4 )
                wrd = new StringBuilder(wrd).reverse().toString();
            convertedString += wrd + " ";
        }
        convertedString = convertedString.trim();
        System.out.println(System.currentTimeMillis() - t1);
        System.out.println(convertedString);

        //with Stream
        t1 = System.currentTimeMillis();
        String convertedString1 = Arrays.stream(s.split(" "))
                .map(word -> word.length() < 5 ? word : new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println(System.currentTimeMillis() - t1);
        System.out.println(convertedString1);

        //with Stream, next version, it works faster!
        t1 = System.currentTimeMillis();
        String convertedString2 = Arrays.stream(s.split(" "))
                .map(word -> word.length() < 5 ? word : new StringBuilder(word).reverse().toString())
                .reduce( (s1,s2) -> s1 + " " + s2 ).orElse("");
        System.out.println(System.currentTimeMillis() - t1);
        System.out.println(convertedString2);

    }
}
