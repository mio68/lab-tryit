package mio68.lab.tryit.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class CompletableFutureWithThread {
    private static Logger LOG = Logger.getLogger(CompletableFutureWithThread.class.getName());

    public static void main(String[] args) throws Exception {

        CompletableFuture<String> completableFuture = getWord();
        String s = completableFuture.get();
        LOG.info(String.format("Got word [%s]", s));
    }

    public static CompletableFuture<String> getWord() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        new Thread(
                () -> {
                    try {
                        LOG.info("begin...");
                        Thread.sleep(3000); // Long action imitation
                        completableFuture.complete("Hello");
                        LOG.info("completed.");
                    } catch (Exception e) {
                        LOG.info(e.toString());
                        completableFuture.completeExceptionally(e);
                    }
                }
        ).start();
        return completableFuture;
    }

}
