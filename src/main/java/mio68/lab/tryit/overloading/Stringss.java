package mio68.lab.tryit.overloading;

public class Stringss {

    public static void main(String[] args) {
        char[] chars = new char[]{'H', 'e', 'l', 'l', 'o', '!'};
        Object o = chars;

        String sChars = String.valueOf(chars);
        String sObject = String.valueOf(o);
        System.out.println(sChars);
        System.out.println(sObject);
//        output
//        Hello!
//        [C@3d075dc0

    }
}
