package de.cytooxien.realms.api.model;

import java.util.UUID;

public record Boost (UUID playerId, long expireTimestamp) {

    public UUID getPlayerId() {
        return playerId;
    }

    public long getExpireTimestamp() {
        return expireTimestamp;
    }


    @Override
    public String toString() {
        return "Boost{" +
                "playerId=" + playerId +
                ", expireTimestamp=" + expireTimestamp +
                '}';
    }
}
