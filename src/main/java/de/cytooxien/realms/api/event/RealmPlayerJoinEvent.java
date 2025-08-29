package de.cytooxien.realms.api.event;

import de.cytooxien.realms.api.enums.JoinReason;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Event triggered when a player joins a realm.
 * Contains the reason for joining.
 */
public class RealmPlayerJoinEvent extends PlayerEvent {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    private final JoinReason joinReason;

    public RealmPlayerJoinEvent(@NotNull Player playerJoined, @NotNull JoinReason joinReason) {
        super(playerJoined);
        this.joinReason = joinReason;
    }

    public JoinReason getJoinReason() {
        return this.joinReason;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}
