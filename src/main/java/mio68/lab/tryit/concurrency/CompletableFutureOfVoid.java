package mio68.lab.tryit.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureOfVoid {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = new CompletableFuture<>();
        completableFuture.complete(null);
        System.out.println("completed with value: " + completableFuture.get());

        completableFuture = CompletableFuture.completedFuture(null);
        System.out.println("completed with value: " + completableFuture.get());


    }

}
