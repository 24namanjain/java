package learning.core;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A simple global enum singleton logger for all feature demonstrations.
 * Provides a standardized way to print outputs.
 */
public enum JavaLogger {
    
    INSTANCE;

    private final Logger logger;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    JavaLogger() {
        logger = Logger.getLogger("GlobalDemoLogger");
    }

    private @NotNull String getPrefix() {
        // Find the caller by looking at the stack trace.
        // Index 0: Thread.getStackTrace()
        // Index 1: JavaLogger.getPrefix()
        // Index 2: JavaLogger.log() / warn() / error()
        // Index 3: The actual caller
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String callerName = "UnknownSource";
        if (stackTrace.length >= 4) {
            String fullClassName = stackTrace[3].getClassName();
            // Just get the simple class name (e.g., "ReferenceDemo" instead of "learning.features.reference.ReferenceDemo")
            callerName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
        }

        return "[" + LocalDateTime.now().format(FORMATTER) + "] [" + Thread.currentThread().getName() + "] [" + callerName + "] ";
    }

    public void log(String message) {
        this.logger.log(Level.INFO, getPrefix() + message);
    }

    public void warn(String message) {
        this.logger.log(Level.WARNING, getPrefix() + message);
    }

    public void error(String message) {
        this.logger.log(Level.SEVERE, getPrefix() + message);
    }

    public void error(String message, @NotNull Throwable t) {
        this.logger.log(Level.SEVERE, getPrefix() + message, t);
    }
    
    public void section(String sectionName) {
        // Using System.out for sections to make them stand out from logs
        System.out.println("\n--- " + sectionName + " ---");
    }
}