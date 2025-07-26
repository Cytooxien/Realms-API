package de.cytooxien.realms.api;

import com.mojang.authlib.properties.Property;
import de.cytooxien.realms.api.enums.JoinReason;
import de.cytooxien.realms.api.enums.Language;
import de.cytooxien.realms.api.model.Boost;

import java.util.List;
import java.util.UUID;

/**
 * This interface provides access to the cytooxien user database. So you can easily resolve player names and uuids
 * without the need to use the mojang api.
 * <br><br>
 * Date: 04.10.2021
 *
 * @author Exceptionflug
 */
public interface PlayerInformationProvider {

    /**
     * This will resolve the name of a cytooxien player.
     *
     * @param uniqueId The uuid of the player
     * @return The username or null if the player was never on cytooxien
     */
    String playerName(UUID uniqueId);

    /**
     * This will resolve the unique id of a cytooxien player.
     *
     * @param name The name of the cytooxien player
     * @return The unique id or null if the player was never on cytooxien
     */
    UUID uniqueId(String name);

    /**
     * This will resolve the player's texture property of a cytooxien player.
     *
     * @param uniqueId The unique id of the player
     * @return The property or null if the player was never on cytooxien
     */
    Property textureProperty(UUID uniqueId);

    /**
     * This will return the Cytooxien language of that player.
     *
     * @param uniqueId The unique id of the player
     * @return The language the player has selected
     */
    Language language(UUID uniqueId);

    /**
     * This will query the amount of active boosts, that the player has used on the realm.
     * @param playerId the player UUID to check
     * @return the count of boosts
     */
    Action<Integer> boostCount(UUID playerId);

    /**
     * This will query all the active boosts which the player has used on the realm.
     * @param playerId the player UUID to check
     * @return {@link List<Boost>} of the boosts
     */
    Action<Boost[]> boosts(UUID playerId);

    /**
     *  This will return the JoinReason of the player
     * @param playerId the player UUID to check
     * @return the JoinReason
     */
    Action<JoinReason> joinReason(UUID playerId);

}
