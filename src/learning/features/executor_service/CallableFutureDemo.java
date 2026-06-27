package learning.features.executor_service;

import learning.core.DemoRunner;
import learning.core.FeatureDemo;
import learning.core.JavaLogger;

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

            FutureTask<Integer> futureTask = new FutureTask<>(callable);
            executor.submit(futureTask);

            JavaLogger.INSTANCE.info("Main Thread running...");

            // futureTask.get()
            // futureTask.get(10, ..) will wait for the future task to be completed before time out
            Integer result = futureTask.get(10, TimeUnit.MILLISECONDS);

            JavaLogger.INSTANCE.info("Result received from the background task is: " + result);
        }
        catch (Exception e) {
            JavaLogger.INSTANCE.error("Exception occurred while executing the task.", e);
            Thread.currentThread().interrupt();
        }
    }
}
