package mio68.lab.tryit.generics;

/**
 * @link https://habr.com/ru/post/665048
 */
public class FromHabr {

    <X extends CharSequence> X getCharSequence() {
        return (X) "hello";
    }
    <X extends String> X getString() {
        return (X) "hello";
    }

    public static void main(String[] args) {
        FromHabr fromHabr = new FromHabr();

        Integer x = fromHabr.getCharSequence();
     //   Integer y = fromHabr.getString();
    }
}
