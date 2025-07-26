package de.cytooxien.realms.api.model;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Boost {

    private final UUID playerId;
    private final Date expireDate;

    private Boost(UUID playerId, Date expireDate) {
        this.playerId = playerId;
        this.expireDate = expireDate;
    }

    public static Boost create(UUID uniqueId, int amount, Date expireDate) {
        return new Boost(uniqueId, expireDate);
    }

    public UUID getUniqueId() {
        return playerId;
    }

    public Date getExpireDate() {
        return expireDate;
    }


    @Override
    public String toString() {
        return "Boost{" +
                "uniqueId=" + playerId +
                ", expireDate=" + expireDate.toString() +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, expireDate);
    }
}
