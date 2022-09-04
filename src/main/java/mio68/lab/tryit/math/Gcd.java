package mio68.lab.tryit.math;

public class Gcd {

    public static int gcd(int i, int j) {
        if (i == 0 && j == 0) {
            throw new IllegalArgumentException("gcd(0, 0) is undefined");
        }
        if (i == 0 || j == 0) {
            return Integer.max(i, j);
        } else {
            if (i == 1 || j == 1) {
                return 1;
            } else {
                return gcd(j, i % j);
            }
        }
    }

    public static int gcd(int i, int j, int k) {
        return gcd(i, gcd(j, k));
    }

    public static int gcd(int i, int j, int k, int l) {
        return gcd(i, gcd(j, k, l));
    }

    public static int gcd(int i, int j, int k, int l, int... args) {
        int res = gcd(i, j, k, l);
        for (int m: args             ) {
            res = gcd(m, res);
        }
        return res;
    }

}
