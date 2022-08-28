package mio68.lab.tryit.assertions;

import java.util.Objects;

public class Assertions {

    public Assertions() {
    }

    private <T> int getLengthWithAssert(T[] arr) {
        assert arr != null;
        return arr.length;
    }

    public  <T> int getLengthWithObjects(T[] arr) {
        return Objects.requireNonNull(arr, "not null array is required").length;
    }



    public static void main(String[] args) {
        Assertions a = new Assertions();

        int len = 0;

        try {
            len = a.getLengthWithAssert(null); // AssertionError if VM options -ea is added
        } catch (Throwable e) {
            e.printStackTrace();
        }

        try {
            len = a.getLengthWithObjects(null); // NullPointerException with custom message
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(len);
    }
}
