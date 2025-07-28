package de.cytooxien.realms.api.model;

import java.util.UUID;

public record Boost(UUID playerId, long expireTimestamp, int amount) {

    public UUID playerId() {
        return playerId;
    }

    public long expireTimestamp() {
        return expireTimestamp;
    }

    public int amount() {
        return amount;
    }


    @Override
    public String toString() {
        return "Boost{" +
                "playerId=" + playerId +
                ", expireTimestamp=" + expireTimestamp +
                ", amount=" + amount +
                '}';
    }
}
