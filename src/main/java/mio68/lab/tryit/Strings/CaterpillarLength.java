package mio68.lab.tryit.Strings;


/*
 https://habr.com/ru/company/jugru/blog/709952/
 UTF-8 использует переменное количество байт на один символ — от 1 до 4.
 UTF-16 кодирует количеством байтов кратным 2.
 UTF-32 фиксированной длины — всегда 4 байта.


*/
public class CaterpillarLength {

    public static void main(String[] args) {
        String caterpillar = "🐛";
        System.out.println(caterpillar.length()); // 2
        System.out.println(toStringOfHex(caterpillar));

        String greet = "Привет Joker";
        System.out.println(toStringOfHex(greet));

        String whatIsThis = "\uD83D\uDC1B";
        System.out.println("this is [" + whatIsThis + "]");
    }

    static String toStringOfHex(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < chars.length; i++) {
            if (i != 0) {
                sb.append(" ,");
            }
            sb.append(String.format("%X", (int)chars[i]));
        }
        return sb.append("]").toString();
    }


}
