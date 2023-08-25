package mio68.lab.tryit.puzzlers.puzzle53;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SomeOtherClass {
    public static int func() {
        return ThreadLocalRandom.current().nextInt(100);
    }
}
