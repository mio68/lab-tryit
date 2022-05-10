package mio68.lab.tryit;

public class PrimeNumbers {

    public static void main(String[] args) {
        for(int i = 1; i <= 100; i++)
            if (isPrime(i)) {
                System.out.println(i);
            }
    }

    public static boolean isPrime(int n) {
        if (n > 100)
            throw new IllegalArgumentException(String.format("%d > 100 and is too big for this dummy method",n));

        if (n <= 0)
            throw new IllegalArgumentException(String.format("%d illegal argument",n));

        return switch (n) {
            case 1 -> false;
            case 2, 3, 5, 7 -> true;
            default -> (n % 2 != 0) && (n % 3 != 0) && (n % 5 != 0) && (n % 7 != 0);
        };
    }
}
