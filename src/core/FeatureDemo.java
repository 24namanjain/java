package core;


import core.exception.FeatureException;

/**
 * Interface representing a modular feature demonstration.
 * All new tutorials should implement this interface.
 */
public interface FeatureDemo {
    /**
     * Execute the demonstration logic.
     */
    void run() throws FeatureException, InterruptedException;
    
    /**
     * Provide a name for the demo.
     */
    default String getName() {
        return this.getClass().getSimpleName();
    }
}