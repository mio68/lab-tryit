package mio68.lab.tryit.codewars;

import java.util.ArrayList;
import java.util.List;

public class SquareNumber {

    /**
     * This method doesn't work!
     */
    public static boolean isSquareNumberByLogicalCondition(int n) {
        if(!String.valueOf(n).matches("\\d*([14569]|(00)+)"))
            return false;

        if(!(n % 4 == 0 || n % 8 == 1))
            return false;

        if(!(n % 9 == 0 || n % 3 == 1))
            return false;

        return  true;
    }

    public static boolean test(int n) {
        return isSquareNumberBySqrt2(n);
    }

    public static boolean isSquareNumberBySqrt(int n) {
        boolean res = false;
        if(n >= 0 ) {
            long iSqrt = Math.round(Math.sqrt(n));
            res = iSqrt * iSqrt == n;
        }
        return res;
    }

    public static boolean isSquareNumberBySqrt2(int n) {
        int iSqrt = (int) Math.round(Math.sqrt(n));
        return  iSqrt * iSqrt == n;
    }

    public static final int N_MAX = 20;
    public static void main(String [] args) {
        List<Integer> preCalculatedSquares = new ArrayList<>();
        List<Integer> foundSquares = new ArrayList<>();
        List<Integer> wrongSquares = new ArrayList<>();

        for(int i = 1; i <= N_MAX; i++)
            preCalculatedSquares.add(i * i);

        for(int i = 1; i <= N_MAX * N_MAX; i++)
            if(test(i))
                if(preCalculatedSquares.contains(i)) {
                    preCalculatedSquares.remove(Integer.valueOf(i));
                    foundSquares.add(i);
                }
                else
                    wrongSquares.add(i);
        report("Missed",preCalculatedSquares);
        report("Found",foundSquares);
        report("Wrong",wrongSquares);

        System.out.println( Math.sqrt(2) % 1); //it is a bit tricky!!!
    }

    public static void report(String title, List<Integer> list) {
        System.out.println(title);
        printList(list);
        System.out.printf("total:%d%n-----------%n", list.size());
    }

    public static void printList(List<Integer> list) {
        list.forEach(System.out::println);
    }
}
