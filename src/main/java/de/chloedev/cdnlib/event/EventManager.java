package de.chloedev.cdnlib.event;

import com.google.common.annotations.Beta;
import de.chloedev.cdnlib.CDNLib;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

public class EventManager {

    /**
     * NOTE: This is still being tested. It does not work yet!<br><br>
     * Allows you to directly create and register an event-listener, useful if you only want to register a one-line event or something similar.<br><br>
     * Example: registerEventListener(PlayerJoinEvent.class, e -> e.setJoinMessage("Some join message"));
     *
     * @param event          the class of the event to listen to.
     * @param onEventTrigger what happens on trigger.
     */
    @Beta
    public static <A extends Event> void registerEventListener(Class<A> event, OnEventTrigger<A> onEventTrigger) {
        Bukkit.getPluginManager().registerEvents(new Listener() {

            private static final HandlerList handlers = new HandlerList();

            @EventHandler
            public void onTrigger(A event) {
                onEventTrigger.onEventTrigger((A) event);
            }

            public static HandlerList getHandlers() {
                return handlers;
            }
        }, CDNLib.getPlugin());
    }

    public interface OnEventTrigger<A extends Event> {
        void onEventTrigger(A event);
    }
}
