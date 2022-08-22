package mio68.lab.tryit;

import java.util.AbstractList;
import java.util.List;

public class CustomCollections {

    public static List<Integer> getPrimesLessThan10() {
        return new AbstractList<>() {
            private static final int[] primes = {2, 3, 5, 7};

            @Override
            public Integer get(int index) {
                return primes[index];
            }

            @Override
            public int size() {
                return primes.length;
            }
        };
    }

    private static class MyArrayList extends AbstractList<Integer> {
        private final int[] arr;

        private MyArrayList(int[] arr) {
            this.arr = arr.clone();
        }

        @Override
        public Integer get(int index) {
            return arr[index];
        }

        @Override
        public int size() {
            return arr.length;
        }
    }

    // Package private version (just for learning purposes)
    static class AnotherArrayList extends MyArrayList {

        public AnotherArrayList(int[] arr) {
            super(arr);
        }
    }

    public static List<Integer> of(int [] arr) {
        return new MyArrayList(arr);
    }

}
