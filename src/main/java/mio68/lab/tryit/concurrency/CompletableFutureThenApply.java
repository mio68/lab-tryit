package mio68.lab.tryit.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CompletableFutureThenApply {

    public static void main(String[] args) throws InterruptedException {

        thenApplyForCompleted();
        thenApplyForUncompleted();
        thenApplyForCompletedExceptionally();

        TimeUnit.SECONDS.sleep(5);
    }

    public static void thenApplyForCompleted() {
        CompletableFuture<String> completed = CompletableFuture.completedFuture("completed");

        // thenApply executes in the main thread, because it's already completed
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

    }

    public static void thenApplyForUncompleted() {
        CompletableFuture<String> uncompleted = new CompletableFuture<>();

        // thenApply will be executed:
        // if it's completed then executes by main thread
        // otherwise it returns completable future to main thread and
        // actually will execute function of thread that completes original CF
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

        // supplier of thenApply will be executed by main thread,
        // because it's the thread that completes the CF!
        uncompleted.complete("completed by main thread");

    }

/*
    This prints:
    java.util.concurrent.ExecutionException: java.lang.Exception: completed with Exception
    at java.base/java.util.concurrent.CompletableFuture.reportGet(CompletableFuture.java:395)
    at java.base/java.util.concurrent.CompletableFuture.get(CompletableFuture.java:2069)
    at mio68.lab.tryit.concurrency.CompletableFutureThenApply.thenApplyForCompletedExceptionally(CompletableFutureThenApply.java:77)
    at mio68.lab.tryit.concurrency.CompletableFutureThenApply.main(CompletableFutureThenApply.java:16)
    Caused by: java.lang.Exception: completed with Exception
    at mio68.lab.tryit.concurrency.CompletableFutureThenApply.thenApplyForCompletedExceptionally(CompletableFutureThenApply.java:68)
            ... 1 more
*/
    public static void thenApplyForCompletedExceptionally() {
        CompletableFuture<String> completedExceptionally = new CompletableFuture<>();
        completedExceptionally.completeExceptionally(new Exception("completed with Exception"));

        CompletableFuture<String> then = completedExceptionally.thenApplyAsync(
                (s) -> {
                    log.info("thenApplyAsync for completed exceptionally");
                    return s + ".then";
                });

        try {
            System.out.println(then.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
