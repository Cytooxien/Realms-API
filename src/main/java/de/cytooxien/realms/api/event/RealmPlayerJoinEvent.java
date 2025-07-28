package de.cytooxien.realms.api.event;

import de.cytooxien.realms.api.enums.JoinReason;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RealmPlayerJoinEvent extends PlayerJoinEvent {

    private final JoinReason joinReason;

    public RealmPlayerJoinEvent(@NotNull Player playerJoined, @Nullable Component joinMessage, @NotNull JoinReason joinReason) {
        super(playerJoined, joinMessage);
        this.joinReason = joinReason;
    }

    public JoinReason getJoinReason() {
        return this.joinReason;
    }
}
