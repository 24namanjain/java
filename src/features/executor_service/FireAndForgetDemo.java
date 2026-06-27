package features.executor_service;

import core.DemoRunner;
import core.FeatureDemo;
import core.JavaLogger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FireAndForgetDemo implements FeatureDemo {

    static void main() {
        DemoRunner.run(new FireAndForgetDemo());
    }

    @Override
    public void run() {
        // Create a fixed pool of 2 threads
        // shutdown() allows running tasks to complete and
        // shutdownNow() kills immediately
        try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {

            for (int i = 1; i <= 10; i++) {
                int taskId = i;

                executorService.execute(() -> {
                    JavaLogger.INSTANCE.info("Fire and Forget task " + taskId + " executing via " + Thread.currentThread().getName());

                    try {
                        Thread.sleep(500);
                    }
                    catch (InterruptedException e) {
                        JavaLogger.INSTANCE.error(e.getMessage());
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }
    }
}
