package mio68.lab.tryit.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CompletableFutureChain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(
                () -> {
                    log.info("supplyAsync");
                    return "supplyAsync";
                }
        ).thenApply(
                (s) -> {
                    log.info("thenApply");
                    return s + ".thenApply";
                }
        ).thenApplyAsync(
                (s) -> {
                    log.info("thenApplyAsync");
                    return s + ".thenApplyAsync";
                }
        );

        System.out.println(cf.get());

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(
                () -> {
                    log.info("supplyAsync");
//                    try {
//                        TimeUnit.SECONDS.sleep(3);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    return "supplyAsync";
                }
        );

//        TimeUnit.SECONDS.sleep(4);

        CompletableFuture<String> cf2 = cf1.thenApply(
                (s) -> {
                    log.info("thenApply");
                    return s + ".thenApply";
                }
        );

        CompletableFuture<String> cf3 = cf2.thenApplyAsync(
                (s) -> {
                    log.info("thenApplyAsync");
                    return s + ".thenApplyAsync";
                }
        );

//        System.out.println("cf1: " + cf1.get());
//        System.out.println("cf2: " + cf2.get());
//        System.out.println("cf3: " + cf3.get());


    }
}
