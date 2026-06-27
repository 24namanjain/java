package learning.core;

import learning.core.exception.FeatureException;

/**
 * Utility class to execute FeatureDemo implementations safely.
 */
public class DemoRunner {

    private DemoRunner() {}

    public static void run(FeatureDemo demo) {
        JavaLogger.INSTANCE.section("[Starting Demo: " + demo.getName() + "]");
        try {
            demo.run();

        } catch (FeatureException e) {
            JavaLogger.INSTANCE.error(e.getMessage());

        } catch (InterruptedException e) {
            JavaLogger.INSTANCE.error("Demo interrupted", e);
            Thread.currentThread().interrupt();

        } catch (Exception e) {
            JavaLogger.INSTANCE.error("Demo failed with exception", e);
        }
        JavaLogger.INSTANCE.section("[Finished Demo: " + demo.getName() + "]");
    }
}