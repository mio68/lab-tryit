package mio68.lab.tryit.codewars;

public class ProdFib {

    public static long[] productFib(long prod) {
        long fb1 = 0, fb2 = 1, t;
        while (fb1 * fb2 < prod) {
            t = fb2;
            fb2 += fb1;
            fb1 = t;
        }
        return new long[]{fb1, fb2, fb1 * fb2 == prod ? 1 : 0};
    }
}
