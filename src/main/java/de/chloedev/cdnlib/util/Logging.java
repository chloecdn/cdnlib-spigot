package de.chloedev.cdnlib.util;

import de.chloedev.cdnlib.CDNLib;

public class Logging {

    /**
     * Log's an info-message into the console with the given message.
     *
     * @param message message to log
     */
    public static void info(String message) {
        CDNLib.getPlugin().getLogger().info(message);
    }

    /**
     * Log's a warning-message into the console with the given message.
     *
     * @param message message to warn
     */
    public static void warn(String message) {
        CDNLib.getPlugin().getLogger().warning(message);
    }

    /**
     * Log's an error-message into the console with the given message.
     *
     * @param message message to error
     */
    public static void error(String message) {
        CDNLib.getPlugin().getLogger().severe(message);
    }
}
