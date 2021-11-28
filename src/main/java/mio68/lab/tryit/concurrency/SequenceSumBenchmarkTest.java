package mio68.lab.tryit.concurrency;

import mio68.lab.tryit.concurrency.SequenceSum;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

//TODO try to move to test directory
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, jvmArgs = {"-Xms4G","-Xmx4G"})
public class SequenceSumBenchmarkTest {
    private static final long N = 10_000_000L;

    @Benchmark
    public long iterativeSum() {
        return SequenceSum.iterativeSum(N);
    }

    @Benchmark
    public long rangedSum() {
        return SequenceSum.rangedSum(N);
    }

    @Benchmark
    public long parallelRangedSum() {
        return SequenceSum.parallelRangedSum(N);
    }

//    @TearDown(Level.Invocation)
//    public void tearDown() {
//        System.gc();
//    }
}
