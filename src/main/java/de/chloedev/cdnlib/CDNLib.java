package de.chloedev.cdnlib;

import de.chloedev.cdnlib.util.Logging;
import org.bukkit.plugin.java.JavaPlugin;

public class CDNLib {

    /**
     * Instance of the plugin that instantiates this lib. used for many of the methods that require access to the plugin.
     */
    private static JavaPlugin plugin;

    public CDNLib(JavaPlugin plugin) {
        CDNLib.plugin = plugin;
        Logging.info("Initialized CDNLib.");
    }

    public static JavaPlugin getPlugin() {
        return plugin;
    }
}