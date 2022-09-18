package mio68.lab.tryit.assertions;

import java.util.Objects;

public class Assertions {

    public Assertions() {
    }

    private <T> int getLengthWithAssert(T[] arr) {
        assert arr != null;
        return arr.length;
    }

    public  <T> int getLengthWithObjectsUtil(T[] arr) {
        return Objects.requireNonNull(arr, "not null array is required").length;
    }



    public static void main(String[] args) {
        Assertions a = new Assertions();

        int len = 0;

        try {
            // AssertionError. VM options -ea is required for assertion to be checked.
            len = a.getLengthWithAssert(null);
        } catch (AssertionError e) {
            e.printStackTrace();
        }

        try {
            // NullPointerException with custom message is thrown
            len = a.getLengthWithObjectsUtil(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(len);
    }
}
