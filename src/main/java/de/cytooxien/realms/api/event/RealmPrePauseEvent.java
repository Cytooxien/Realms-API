package de.cytooxien.realms.api.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * This is an event which gets called when the realm prepares to get paused.
 * There isn't much time in between the RealmPrePauseEvent and the actual pause of the realm.
 */
public class RealmPrePauseEvent extends Event {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}
