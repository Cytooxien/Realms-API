package de.cytooxien.realms.api;

import com.mojang.authlib.properties.Property;

import java.util.Locale;
import java.util.UUID;

/**
 * This interface provides access to the cytooxien user database. So you can easily resolve player names and uuids
 * without the need to use the mojang api.
 * <br><br>
 * Date: 04.10.2021
 * @author Exceptionflug
 */
public interface PlayerInformationProvider {

    /**
     * This will resolve the name of a cytooxien player.
     * @param uniqueId The uuid of the player
     * @return The username or null if the player was never on cytooxien
     */
    String playerName(UUID uniqueId);

    /**
     * This will resolve the unique id of a cytooxien player.
     * @param name The name of the cytooxien player
     * @return The unique id or null if the player was never on cytooxien
     */
    UUID uniqueId(String name);

    /**
     * This will resolve the player's texture property of a cytooxien player.
     * @param uniqueId The unique id of the player
     * @return The property or null if the player was never on cytooxien
     */
    Property textureProperty(UUID uniqueId);

    /**
     * This will return the Cytooxien language of that player.
     * @param uniqueId The unique id of the player
     * @return The language the player has selected
     */
    String language(UUID uniqueId);

}
