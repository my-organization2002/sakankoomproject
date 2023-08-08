package other;

import java.util.logging.Level;

public class LogLevelSetter {

    private LogLevelSetter() {
        throw new IllegalStateException("Utility class");
    }

    public static void setLevel(java.util.logging.Logger logger) {
        setLevelLogger(logger);
    }

    private static void setLevelLogger(java.util.logging.Logger logger) {
        logger.setLevel(Level.INFO);
    }
}