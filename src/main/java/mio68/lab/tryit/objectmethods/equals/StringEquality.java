package mio68.lab.tryit.objectmethods.equals;

public class StringEquality {

    public static void main(String[] args) {
        String s1 = new String("Hello!");
        String s2 = new String("Hello!");
        String s3 = new String("Hello!");

        EqualContractChecker.printEqualContractInfo(s1, s2, s3);
    }
}
