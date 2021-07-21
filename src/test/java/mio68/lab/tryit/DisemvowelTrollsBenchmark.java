package mio68.lab.tryit;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

public class DisemvowelTrollsBenchmark {
    public static final String testString = "Hello World!";

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void disemvowelBenchmark() {
        DisemvowelTrolls.disemvowel(testString);
    }

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void disemvowel2Benchmark() {
        DisemvowelTrolls.disemvowel2(testString);
    }

}
