package de.chloedev.cdnlib.io;

import de.chloedev.cdnlib.CDNLib;
import de.chloedev.cdnlib.util.Logging;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileConfiguration {

    private YamlConfiguration config;
    private File configFile;

    public FileConfiguration(String name) {
        try {
            if (!name.endsWith(".yml") && !name.endsWith(".yaml")) name += ".yml";
            this.configFile = new File(CDNLib.getPlugin().getDataFolder() + File.separator + name);
            if (!CDNLib.getPlugin().getDataFolder().exists()) CDNLib.getPlugin().getDataFolder().mkdirs();
            if (!this.configFile.exists()) {
                this.configFile.createNewFile();
                Logging.info("Created Config-File '" + name + "'.");
            }
            this.config = YamlConfiguration.loadConfiguration(this.configFile);
            Logging.info("Loaded Config-File '" + name + "'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T getFromType(Class<T> type, String path) {
        return (T) this.config.get(path);
    }

    public void set(String path, Object value) {
        try {
            this.config.set(path, value);
            this.config.save(this.configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean contains(String path) {
        return this.config.contains(path);
    }
}
