package features.executor_service;

import core.DemoRunner;
import core.FeatureDemo;
import core.JavaLogger;

import java.util.concurrent.*;

public class CallableFutureDemo implements FeatureDemo {

    static void main() {
        DemoRunner.run(new CallableFutureDemo());
    }

    @Override
    public void run() {
        try (ExecutorService executor = Executors.newCachedThreadPool()) {

            // Callable returns a value and can throw checked exception
            Callable<Integer> callable = () -> {
                for (int i = 0; i < 10; i++) {
                    JavaLogger.INSTANCE.info("i = " + i);
                    Thread.sleep(1);
                }

                return ThreadLocalRandom.current().nextInt(100);
            };

            JavaLogger.INSTANCE.info("Submitting the task...");

            // Why we need Future & FutureTask?
            // Future is an interface that represents a result of an asynchronous computation.
            // FutureTask is a concrete implementation of Future that can be used to represent a result of an asynchronous computation.
            FutureTask<Integer> futureTask = new FutureTask<>(callable);
            executor.submit(futureTask);

            JavaLogger.INSTANCE.info("Main Thread running...");

            // Blocks until the background task completes and returns its result
            // futureTask.get(10, ..) will wait for the future task to be completed before time out
            Integer result = futureTask.get();

            JavaLogger.INSTANCE.info("Result received from the background task is: " + result);
        } catch (InterruptedException e) {
            JavaLogger.INSTANCE.error("Interrupted while waiting for task result.", e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            JavaLogger.INSTANCE.error("Task failed during execution.", e.getCause());
        }
    }
}
