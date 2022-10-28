package mio68.lab.tryit.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CompletableFutureThenApply {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<String> completed = CompletableFuture.completedFuture("completed");

        // thenApply executes in the main thread
        completed.thenApply((s) -> {
                    log.info("thenApply for initially completed");
                    return s + ".thenApply";
                }
        );

        // thenApply executes with thread from ForkJoinPool
        completed.thenApplyAsync((s) -> {
                    log.info("thenApplyAsync  for initially completed");
                    return s + ".thenApplyAsync";
                }
        );

        CompletableFuture<String> uncompleted = new CompletableFuture<>();

        // thenApply will be executed by client thread
        uncompleted.thenApply((s) -> {
                    log.info("thenApply for initially uncompleted");
                    return s + ".thenApply";
                }
        );

        // thenApply executes with thread from ForkJoinPool
        uncompleted.thenApplyAsync((s) -> {
                    log.info("thenApplyAsync for initially uncompleted");
                    return s + ".thenApplyAsync";
                }
        );

        uncompleted.complete("completed by main thread"); // supplier of thenApply will be executed by main thread

        TimeUnit.SECONDS.sleep(5);
    }

}
