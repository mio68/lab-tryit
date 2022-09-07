package mio68.lab.tryit.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountSumAvgMinMaxStat {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Counting ----------");
        System.out.println("count: " + list.stream().count());
        System.out.println("count with collector: " +
                list.stream().collect(Collectors.counting()));
        System.out.println("count with reduce: " +
                list.stream().reduce(0, (i, j) -> i + 1));
        System.out.println("count with collector-reducing: " +
                list.stream().collect(Collectors.reducing(0,(i, j) -> i + 1)));

        System.out.println("Summing -----------");
        System.out.println("sum with collector: " +
                list.stream().collect(Collectors.summingInt(Integer::intValue)));
        System.out.println("sum with reduce: " +
                list.stream().reduce(0, Integer::sum));
        System.out.println("sum with IntStream: " +
                list.stream().mapToInt(Integer::intValue).sum());


        System.out.println("Averaging -----");
        System.out.println("Average with collector: " +
                list.stream().collect(Collectors.averagingInt(Integer::intValue)));
        System.out.println("Average with IntStream: " +
                list.stream().mapToInt(Integer::intValue).average());

        System.out.println("Find max -----------");
        System.out.println("Find max with collector: " +
                list.stream().collect(Collectors.maxBy(Integer::compare)));
        System.out.println("Find max with reduce: " +
                list.stream().reduce(Integer::max));
        System.out.println("Find max with IntStream: " +
                list.stream().mapToInt(Integer::intValue).max());
        System.out.println("Find max with max: " +
                list.stream().max(Integer::compare));

        System.out.println("Statistic --------");
        System.out.println("Statistic with collector: " +
                list.stream().collect(Collectors.summarizingInt(Integer::intValue)));
    }
}
