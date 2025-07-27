package de.cytooxien.realms.api.model;

import java.util.UUID;

public record Boost(UUID playerId, long expireTimestamp) {

    public UUID playerId() {
        return playerId;
    }

    public long expireTimestamp() {
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
