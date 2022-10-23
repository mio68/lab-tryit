package mio68.lab.tryit.concurrency;

import java.util.concurrent.*;

public class CompletableFutureSimple {

    public static void main(String[] args) throws Exception {
        CompletableFuture<String> completableFuture = getWord();
        System.out.println("Got word " + completableFuture.get());

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = getWordExceptionally(executorService);
        System.out.println("Got another word " + future.get());

        executorService.shutdown();
    }


    public static CompletableFuture<String> getWord() {
        // Supplier doesn't allow exception throwing
        return CompletableFuture.supplyAsync(() -> "Hello");
    }

    public static Future<String> getWordExceptionally(ExecutorService executorService) {

        Callable<String> task = () -> {
            Thread.sleep(3000);
            return "Hello World!";
        };

        return executorService.submit(task);
    }
}