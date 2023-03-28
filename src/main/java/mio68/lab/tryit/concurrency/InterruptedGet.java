package mio68.lab.tryit.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/*
    Future::get и CompletableFuture::get бросят InterruptedException в любом
    случае:
    1. Thread вызывающий get был прерван до вызова get
    2. Thread вызывающий get был прерван во время ожидания возврата из get

From CompletableFuture documentation:
Since (unlike FutureTask) this class has no direct control over the computation that causes
it to be completed, cancellation is treated as just another form of exceptional completion.
Method cancel has the same effect as completeExceptionally(new CancellationException()).
Method isCompletedExceptionally() can be used to determine if a CompletableFuture completed
in any exceptional fashion.
Parameters:
    mayInterruptIfRunning - this value has no effect in this implementation because interrupts are not used to control processing.
...

So CompletableFuture::cancel doesn't interrupt any thread, and execution continues even
for canceled CompletableFuture.

 */


@Slf4j
public class InterruptedGet {

    static ExecutorService executorService = Executors.newFixedThreadPool(8);

    public static void main(String[] args) throws InterruptedException {
        interruptedGetForFuture(InterruptionMode.NO_INTERRUPTION);
        interruptedGetForFuture(InterruptionMode.INTERRUPT_BEFORE_GET);
        interruptedGetForFuture(InterruptionMode.INTERRUPT_WHILE_GET);

        interruptedGetForCompletableFuture(InterruptionMode.NO_INTERRUPTION);
        interruptedGetForCompletableFuture(InterruptionMode.INTERRUPT_BEFORE_GET);
        interruptedGetForCompletableFuture(InterruptionMode.INTERRUPT_WHILE_GET);

        executorService.awaitTermination(10, TimeUnit.SECONDS);
        log.info("done!");
    }

    public static void interruptedGetForFuture(InterruptionMode mode) throws InterruptedException {

        Future<String> future = executorService.submit(() -> {
            for (int i = 0; i < 10; i++) {

                if (Thread.interrupted()) {
                    log.info("cycled execution is interrupted");
                    throw new InterruptedException("cycled execution is interrupted");
                }

                log.info("iteration %s".formatted(i));
                longOperation();
            }
            log.info("completed");
            return "completed";
        });

        // interruption before get causes exception
        // 11:17:59.742 [main] INFO mio68.lab.tryit.concurrency.InterruptedGet - future.get()
        if (mode == InterruptionMode.INTERRUPT_BEFORE_GET) {
            TimeUnit.SECONDS.sleep(3);
            Thread.currentThread().interrupt();
        }

        if (mode == InterruptionMode.INTERRUPT_WHILE_GET) {
            Thread currentThread = Thread.currentThread();
            executorService.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    log.info("interrupter is interrupted");
                }
                currentThread.interrupt();
            });
        }

        try {
            log.info("future.get(): %s".formatted(future.get()));
        } catch (InterruptedException | ExecutionException e) {
            future.cancel(true);
            log.info("future.get()", e);
        }

        // clear interrupted flag
        Thread.interrupted();
    }

    public static void interruptedGetForCompletableFuture(InterruptionMode mode)
            throws InterruptedException {

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
                    for (int i = 0; i < 10; i++) {

                        // This never occurs!
                        if (Thread.interrupted()) {
                            log.info("cycled execution is interrupted");
                            throw new RuntimeException("cycled execution is interrupted");
                        }

                        // Current thread never interupts by this CompletableFuture::cancel
                        // This situation can occur by any other reason.
                        log.info("iteration %s".formatted(i));
                        try {
                            longOperation();
                        } catch (InterruptedException e) {
                            log.info("long operation failed", e);
                            throw new RuntimeException("long operation failed", e);
                        }
                    }
                    log.info("completed");
                    return "completed";
                },
                executorService);

        // interruption before get causes exception
        // 11:17:59.742 [main] INFO mio68.lab.tryit.concurrency.InterruptedGet - future.get()
        if (mode == InterruptionMode.INTERRUPT_BEFORE_GET) {
            TimeUnit.SECONDS.sleep(3);
            Thread.currentThread().interrupt();
        }

        if (mode == InterruptionMode.INTERRUPT_WHILE_GET) {
            Thread currentThread = Thread.currentThread();
            executorService.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    log.info("interrupter is interrupted");
                }
                currentThread.interrupt();
            });
        }

        try {
            log.info("completableFuture.get(): %s".formatted(completableFuture.get()));
        } catch (InterruptedException | ExecutionException e) {
            completableFuture.cancel(true);
            log.info("completableFuture.get()", e);
        }

    }

    private static void longOperation() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }

    enum InterruptionMode {
        NO_INTERRUPTION, INTERRUPT_BEFORE_GET, INTERRUPT_WHILE_GET
    }

}
