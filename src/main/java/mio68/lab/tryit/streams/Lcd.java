package mio68.lab.tryit.streams;

public class Lcd {

    public static int lcd(int i, int j) {
        if (j == 0) {
            return i;
        } else {
            return lcd(j, i % j);
        }
    }

    public static void main(String[] args) {
        System.out.println(lcd(10, 3));
        System.out.println(lcd(8, 6));
        System.out.println(lcd(42, 12));
        System.out.println(lcd(3, 10));
        System.out.println(lcd(6, 8));
        System.out.println(lcd(12, 42));
    }
}
