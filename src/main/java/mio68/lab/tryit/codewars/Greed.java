package mio68.lab.tryit.codewars;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import static java.util.stream.Collectors.*;

public class Greed{
    public static int greedy(int[] dice){
        AtomicInteger total = new AtomicInteger(0);
        Arrays.stream(dice).boxed()
                .collect(groupingBy(v -> v, counting()))
                .forEach((v,c) -> total.addAndGet(points(v, c.intValue())));
        return total.intValue();
    }

    private static int points(int v, int counter) {
        if(v == 1)
            v = 10; // 1 actually means 10 here

        return  (counter >= 3 ? v * 100 : 0) // if any value repeats 3 or more times.  можно было улучшить! (counter / 3) * v * 100
                + (v % 5 == 0 ? v * 10 * (counter % 3) : 0); // for values 10 and 5 add some more points :)
    }
}