package de.cytooxien.realms.api.model;

import java.util.Objects;
import java.util.UUID;

public class Boost {

    private final UUID playerId;
    private final long expireTimestamp;

    private Boost(UUID playerId, long expireTimestamp) {
        this.playerId = playerId;
        this.expireTimestamp = expireTimestamp;
    }

    public static Boost create(UUID playerId, long expireTimestamp) {
        return new Boost(playerId, expireTimestamp);
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(playerId, expireTimestamp);
    }
}
