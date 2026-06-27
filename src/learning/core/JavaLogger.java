package learning.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
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
        logger.setUseParentHandlers(false);
        
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord logRecord) {
                return logRecord.getMessage() + "\n";
            }
        });
        logger.addHandler(handler);
    }

    private String getPrefix() {
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
        info(message);
    }

    public void info(String message) {
        String logMsg = getPrefix() + message;
        this.logger.log(Level.INFO, logMsg);
    }

    public void warn(String message) {
        String logMsg = getPrefix() + message;
        this.logger.log(Level.WARNING, logMsg);
    }

    public void error(String message) {
        String logMsg = getPrefix() + message;
        this.logger.log(Level.SEVERE, logMsg);
    }

    public void error(String message, Throwable t) {
        String logMsg = getPrefix() + message;
        this.logger.log(Level.SEVERE, logMsg, t);
    }

    public void section(String sectionName) {
        String logMsg = String.format("%n--- %s ---", sectionName);
        this.logger.info(logMsg);
    }
}
