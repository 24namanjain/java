package learning.core;

import org.jetbrains.annotations.NotNull;

/**
 * Utility class to execute FeatureDemo implementations safely.
 */
public class DemoRunner {

    private DemoRunner() {}

    public static void run(@NotNull FeatureDemo demo) {
        JavaLogger.INSTANCE.section("Starting Demo: " + demo.getName());
        try {
            demo.run();
            JavaLogger.INSTANCE.log("Demo completed successfully.");
        } catch (Exception e) {
            JavaLogger.INSTANCE.error("Demo failed with exception", e);
        }
        JavaLogger.INSTANCE.section("Finished Demo: " + demo.getName() + "\n");
    }
}