package de.chloedev.cdnlib.command;

import de.chloedev.cdnlib.CDNLib;
import org.bukkit.command.CommandExecutor;

public class CommandManager {
    /**
     * Registers the given command, that will run the given runAction when someone runs it.
     * Using this method doesn't require you to add it to the plugin.yml. Instead it uses Reflection to "inject" the command into vanilla's CommandMap
     *
     * @param command   The name of the command to register.
     * @param executor the action to perform when someone runs the command.
     */

    public static void register(String command, CommandExecutor executor) {
        CommandUtils.addCommandToMap(command);
        assert false;
        CDNLib.getPlugin().getCommand(command).setExecutor((sender, cmd, label, args) -> {
            executor.onCommand(sender, cmd, label, args);
            return false;
        });
    }
}