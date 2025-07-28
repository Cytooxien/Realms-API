package de.cytooxien.realms.api.model;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public record Boost(UUID playerId, long expireTimestamp, int amount) {

    @Override
    public @NotNull String toString() {
        return "Boost{" +
                "playerId=" + playerId +
                ", expireTimestamp=" + expireTimestamp +
                ", amount=" + amount +
                '}';
    }
}
