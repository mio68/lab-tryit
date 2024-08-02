package mio68.lab.tryit.completablefuture;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/*
 * Формируем CompletableFuture для:  три запроса - обработка результатов запросов с получением
 * сводного результата
 */

@Slf4j
public class WaitForRequestResultsThenProcessIt {

    private static final int MIN_DELAY_MS = 1000;
    private static final int MAX_DELAY_MS = 3000;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> request1 = CompletableFuture.supplyAsync(
                () -> (new Request("Request1")).getResult());

        CompletableFuture<String> request2 = CompletableFuture.supplyAsync(
                () -> (new Request("Request2")).getResult());

        CompletableFuture<String> request3 = CompletableFuture.supplyAsync(
                () -> (new Request("Request3")).getResult());

        CompletableFuture<String> result = CompletableFuture.allOf(request1, request2, request3)
                        .thenApply(v -> report(request1.join(), request2.join(), request3.join()));

        try {
            CompletableFuture.allOf(request1, request2, request3).join();
        } catch (Exception e) {
            log.info("Wait for all completion failed", e);
        }


        try {
            log.info("Final result: [{}]", result.get());
        } catch (InterruptedException | ExecutionException e) {
            log.info("Getting result failed", e);
        }
    }

    private static String report(String... results) {
        log.info("Create report...");
        long delay = randomDelay();
        if (delay > 2000) {
            throw new RuntimeException("Report creating failed");
        }
        return String.join(";", results);
    }

    @RequiredArgsConstructor
    private static class Request {
        private final String name;

        String getResult() {
            long delay = randomDelay();
            if (delay > 2000) {
                throw new RuntimeException(name + " failed");
            }
            log.info(name + " is done.");
            return "Result of " + name;
        }

    }

    private static long randomDelay() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        long delay = threadLocalRandom.nextLong(MIN_DELAY_MS, MAX_DELAY_MS);
        try {
            TimeUnit.MILLISECONDS.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted");
        }
        return delay;
    }
}
