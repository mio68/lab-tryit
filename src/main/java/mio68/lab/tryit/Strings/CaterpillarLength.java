package mio68.lab.tryit.Strings;

// https://habr.com/ru/company/jugru/blog/709952/

public class CaterpillarLength {

    public static void main(String[] args) {
        String caterpillar = "🐛";
        System.out.println(caterpillar.length()); // 2

        char[] chars = caterpillar.toCharArray(); // '\uD83D', '\uDC1B'



        for (char c : chars) {
            System.out.println(Integer.toHexString(c));
        }

    }
}
