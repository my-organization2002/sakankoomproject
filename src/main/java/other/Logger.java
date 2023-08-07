package other;

import java.util.logging.Level;
public class Logger {
    private Logger() {
        throw new IllegalStateException("Utility class");
    }

    public static void setLevel(java.util.logging.Logger logs) {
        setLevelLogger(logs);
    }

    private static void setLevelLogger(java.util.logging.Logger logs) {
        logs.setLevel(Level.INFO);
    }
}
