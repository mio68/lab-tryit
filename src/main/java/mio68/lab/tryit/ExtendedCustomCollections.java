package mio68.lab.tryit;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExtendedCustomCollections extends CustomCollections {

    public static List<Integer> of(int[] num) {
        return IntStream.of(num)
                .boxed()
                .collect(Collectors.toList());
    }

}
