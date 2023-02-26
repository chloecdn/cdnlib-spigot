package de.chloedev.cdnlib.event;

import de.chloedev.cdnlib.CDNLib;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class EventManager {

    /**
     * Allows you to directly create and register an event-listener, useful if you only want to register a one-line event or something similar.<br><br>
     * Example: registerEventListener(PlayerJoinEvent.class, e -> e.setJoinMessage("Some join message"));
     *
     * @param event          the class of the event to listen to.
     * @param onEventTrigger what happens on trigger.
     */
    public static <A extends Event> void registerEventListener(Class<A> event, OnEventTrigger<A> onEventTrigger) {
        Bukkit.getPluginManager().registerEvents(new Listener() {
            @EventHandler(priority = EventPriority.HIGHEST)
            public void onEventTrigger(A event) {
                onEventTrigger.onEventTrigger(event);
            }
        }, CDNLib.getPlugin());
    }

    public interface OnEventTrigger<A extends Event> {
        void onEventTrigger(A event);
    }
}
