package de.cytooxien.realms.api.event;

import com.destroystokyo.paper.profile.PlayerProfile;
import de.cytooxien.realms.api.model.Boost;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Event triggered when a player boosts a realm.
 * If the realm is offline or paused, the event will be triggered once the realm is back online.
 */
public class RealmBoostEvent extends Event {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    private final Boost boost;
    private final PlayerProfile playerProfile;

    public RealmBoostEvent(@NotNull Boost boost, @NotNull PlayerProfile playerProfile) {
        this.boost = boost;
        this.playerProfile = playerProfile;
    }

    public Boost getBoost() {
        return this.boost;
    }

    public UUID getPlayerId() {
        return this.boost.playerId();
    }

    @Nullable
    public PlayerProfile getPlayerProfile() {
        return this.playerProfile;
    }

    public int getBoostAmount() {
        return this.boost.amount();
    }

    public long getExpireTimestamp() {
        return this.boost.expireTimestamp();
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}
