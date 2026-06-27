package learning.features.executor_service;

import learning.core.DemoRunner;
import learning.core.FeatureDemo;
import learning.core.JavaLogger;

import java.util.Map;
import java.util.concurrent.*;

public class ProductionPoolDemo implements FeatureDemo {

    static void main() {
        DemoRunner.run(new ProductionPoolDemo());
    }

    @Override
    public void run() throws InterruptedException {
        for (Map.Entry<RejectedExecutionHandler, String> entry : getRejectedExecutionHandler().entrySet()) {
            RejectedExecutionHandler policyClass = entry.getKey();
            String explanation = entry.getValue();

            JavaLogger.INSTANCE.info("\n==================================================");
            JavaLogger.INSTANCE.info("TESTING POLICY: " + policyClass.getClass().getName());
            JavaLogger.INSTANCE.info("BEHAVIOR: " + explanation);
            JavaLogger.INSTANCE.info("==================================================");

            // Explicitly create the pool manually without try-with-resources to preserve tracking
            try (ThreadPoolExecutor pool = new ThreadPoolExecutor(
                    2,                          // corePoolSize
                    4,                          // maximumPoolSize
                    60L, TimeUnit.SECONDS,      // keepAliveTime
                    new LinkedBlockingQueue<>(2), // Bounded Queue Capacity
                    entry.getKey()
            )) {

                for (int i = 1; i <= 7; i++) {
                    int taskId = i;
                    try {
                        pool.submit(() -> {
                            JavaLogger.INSTANCE.info("[" + Thread.currentThread()
                                                                     .getName() + "] Processing task " + taskId);
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                JavaLogger.INSTANCE.error("Exception occurred while executing the task.", e);
                                Thread.currentThread().interrupt();
                            }
                        });
                    } catch (RejectedExecutionException e) {
                        JavaLogger.INSTANCE.error("[REJECTED] Task " + taskId + " caught by exception block.", e);
                    }
                }
                boolean _ = pool.awaitTermination(2, TimeUnit.SECONDS);
            }
        }
    }

    static Map<RejectedExecutionHandler, String> getRejectedExecutionHandler() {
        ThreadPoolExecutor.AbortPolicy abortPolicy = new ThreadPoolExecutor.AbortPolicy();
        ThreadPoolExecutor.CallerRunsPolicy callerRunsPolicy = new ThreadPoolExecutor.CallerRunsPolicy();
        ThreadPoolExecutor.DiscardPolicy discardPolicy = new ThreadPoolExecutor.DiscardPolicy();
        ThreadPoolExecutor.DiscardOldestPolicy discardOldestPolicy = new ThreadPoolExecutor.DiscardOldestPolicy();

        // Map the Class definitions to their explanations for clean logging
        return Map.of(
                abortPolicy,
                "Throws a runtime RejectedExecutionException immediately.",

                discardPolicy,
                "Silently drops the newly submitted task without an exception.",

                discardOldestPolicy,
                "Evicts the oldest unhandled task sitting at the head of the queue.",

                callerRunsPolicy,
                "Forces the caller thread to execute it synchronously."
        );
    }
}
