package mio68.lab.tryit.concurrency;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.*;
import java.util.function.Supplier;

@Slf4j
public class ConcurrentCompletableFutures100 {

    public static final int MIN_RESPONSE_DELAY_MILLIS = 2000;
    public static final int MAX_RESPONSE_DELAY_MILLIS = 5000;
    public static final int NUMBER_OF_EXTERNAL_SERVICES = 100;

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_EXTERNAL_SERVICES);

        CompletableFuture<?>[] longTermServiceCalls = new CompletableFuture[NUMBER_OF_EXTERNAL_SERVICES];
        for (int i = 0; i < NUMBER_OF_EXTERNAL_SERVICES; i++) {
            // Create long term service.
            LongTermService longTermService = new LongTermService(i);
            // Call long term service asynchronously.
            CompletableFuture<ServiceDescriptor> longTermServiceCall = CompletableFuture.supplyAsync(
                    longTermService,
                    executorService);

            // Add callback to long term service call.
            // Do something with long term service response.
            CompletableFuture<ServiceDescriptor> longTermServiceCallWithCallback =
                    longTermServiceCall.whenComplete((descriptor, throwable) ->
                        log.info(
                                String.format(
                                        "Service call completed with descriptor [%s], throwable [%s]",
                                        descriptor,
                                        throwable != null ? throwable.toString() : null ))
                    );

            // Put to array
            longTermServiceCalls[i] = longTermServiceCallWithCallback;
        }

        log.info(String.format("Number of external service calls is [%d]", NUMBER_OF_EXTERNAL_SERVICES));
        long startTime = System.currentTimeMillis();

        // Wait all of them!
        CompletableFuture<Void> waitForComplete = CompletableFuture.allOf(longTermServiceCalls);
        // Register a callback to log completion time;
        waitForComplete.whenComplete((unused, throwable) -> {
            long endTime = System.currentTimeMillis();
            if (throwable != null) {
                log.info("Completed with exception: [{}] ", throwable.toString());

            }
            log.info("Total complete time: [{}] msec.", endTime - startTime);
        });

        // Callback if all of them are completed normally.
        waitForComplete.thenAccept(unused -> log.info("All are completed normally!"));


        // Wait 3 seconds. Some external calls will complete normally, some of them
        // will be interrupted.
        TimeUnit.MILLISECONDS.sleep(3000);
        executorService.shutdownNow();
        // Wait for termination.
        TimeUnit.MILLISECONDS.sleep(1000);

        // Gather some statistics.
        long completedExceptionally = Arrays.stream(longTermServiceCalls)
                .filter(CompletableFuture::isCompletedExceptionally)
                .count();

        long done = Arrays.stream(longTermServiceCalls)
                .filter(CompletableFuture::isDone)
                .count();

        long cancelled = Arrays.stream(longTermServiceCalls)
                .filter(CompletableFuture::isCancelled)
                .count();

        System.out.println("done: " + done);
        System.out.println("exceptionally: " + completedExceptionally);
        System.out.println("cancelled: " + cancelled);

    }

    public static class LongTermService implements Supplier<ServiceDescriptor> {
        private final int id;
        private final int delay;

        public LongTermService(int id) {
            this.id = id;
            this.delay = getRandomDelayMilliseconds();
        }

        @Override
        public ServiceDescriptor get() {
            try {
                TimeUnit.MILLISECONDS.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(String.format("Service [%d] call is interrupted.", id), e);
            }
            return new ServiceDescriptor(id, delay);
        }

    }

    @Value
    public static class ServiceDescriptor {
        int id;
        int delay;
    }

    public static int getRandomDelayMilliseconds() {
        return ThreadLocalRandom.current().nextInt(
                MIN_RESPONSE_DELAY_MILLIS,
                MAX_RESPONSE_DELAY_MILLIS);
    }
}
