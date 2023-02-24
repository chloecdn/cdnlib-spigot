package de.chloedev.cdnlib.command;

import de.chloedev.cdnlib.CDNLib;
import de.chloedev.cdnlib.util.Logging;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandManager {

    /**
     * Registers the given command, that will run the given runAction when someone runs it.
     * NOTE: You still need to register this command in your "plugin.yml", or else it'll log an error and won't register that command.
     *
     * @param command   The name of the command to register.
     * @param runAction the action to perform when someone runs the command.
     * @deprecated This method is deprecated in favor of the method {@link CommandManager#registerVanilla(String, RunAction)},
     * which doesn't require adding every command to the 'plugin.yml' manually.
     */
    @Deprecated
    public static void register(String command, RunAction runAction) {
        if (CDNLib.getPlugin().getCommand(command) == null) {
            Logging.error("Error while registering command '" + command + "'. Did you forget to register it in your 'plugin.yml'?");
            return;
        }
        CDNLib.getPlugin().getCommand(command).setExecutor((sender, cmd, label, args) -> {
            runAction.run(sender, cmd, label, args);
            return false;
        });
    }

    /**
     * Registers the given command, that will run the given runAction when someone runs it.
     * Using this method doesn't require you to add it to the plugin.yml. Instead it uses Reflection to "inject" the command into vanilla's CommandMap
     *
     * @param command   The name of the command to register.
     * @param runAction the action to perform when someone runs the command.
     */
    public static void registerVanilla(String command, RunAction runAction) {
        CommandUtils.addCommandToMap(command);
        CDNLib.getPlugin().getCommand(command).setExecutor((sender, cmd, label, args) -> {
            runAction.run(sender, cmd, label, args);
            return false;
        });
    }

    public interface RunAction {
        void run(CommandSender sender, Command command, String label, String[] args);
    }
}
