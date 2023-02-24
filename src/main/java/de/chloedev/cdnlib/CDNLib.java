package de.chloedev.cdnlib;

import org.bukkit.plugin.java.JavaPlugin;

public class CDNLib {

    /**
     * Instance of the plugin that instantiates this lib. used for many of the methods that require access to the plugin.
     */
    private static JavaPlugin plugin;

    public CDNLib(JavaPlugin plugin, String logMessage) {
        CDNLib.plugin = plugin;
        Logging.info(logMessage);
    }

    public CDNLib(JavaPlugin plugin) {
        this(plugin, "Initialized CDNLib.");
    }

    public static JavaPlugin getPlugin() {
        return plugin;
    }
}