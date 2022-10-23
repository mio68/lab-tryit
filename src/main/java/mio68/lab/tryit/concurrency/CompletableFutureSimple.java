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

        System.out.println("Got word " + getWordExceptionally(false).get());

        System.out.println("Try to say never!");
        System.out.println("Got word " + getWordExceptionally(true).get());

    }


    public static CompletableFuture<String> getWord() {
        // Supplier doesn't allow exception throwing
        return CompletableFuture.supplyAsync(() -> "Hello");
    }

    public static CompletableFuture<String> getWordExceptionally(boolean throwException) {
        // Supplier doesn't allow exception throwing
        return CompletableFuture.supplyAsync(() -> {
            if (throwException) {
                throw new RuntimeException("Exception throwing is requested!");
            } else {
                return "Never say never again!";
            }
        });
    }

    public static Future<String> getWordExceptionally(ExecutorService executorService) {

        Callable<String> task = () -> {
            Thread.sleep(3000);
            return "Hello World!";
        };

        return executorService.submit(task);
    }
}