package de.cytooxien.realms.api;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * The DisplayProvider interface defines the methods required to manage and retrieve display prefixes and suffixes
 * for players. This includes customization of both tab-list and chat display
 * elements using adventure's {@link Component} system.
 */
public interface DisplayProvider {

    /**
     * Sets the suffix for a player in the tab list.
     *
     * @param player The player for whom the tab suffix is to be set.
     * @param suffix The {@link Component} representing the suffix to be displayed in the tab list for the specified
     *               player or null if disabled.
     */
    void setTabSuffix(Player player, Component suffix);

    /**
     * Sets the suffix for a player in chat messages.
     *
     * @param player The player for whom the chat suffix is to be set.
     * @param suffix The {@link Component} representing the suffix to be displayed in chat messages for the specified
     *               player or null if disabled.
     */
    void setChatSuffix(Player player, Component suffix);

    /**
     * Sets a custom prefix for a player in the tab list. This will overwrite the group prefix of the player.
     *
     * @param player The player for whom the tab list prefix is to be set.
     * @param prefix The {@link Component} representing the prefix to be displayed in the tab list for the specified
     *               player or null if the group prefix should be used.
     */
    void setCustomTabPrefix(Player player, Component prefix);

    /**
     * Sets a custom prefix for a player in chat messages. This will overwrite the group prefix of the player.
     *
     * @param player The player for whom the chat message prefix is to be set.
     * @param prefix The {@link Component} representing the prefix to be displayed in chat messages for the specified
     *              player or null if the group prefix should be used.
     */
    void setCustomChatPrefix(Player player, Component prefix);

    /**
     * Retrieves the current suffix set for players in the tab list.
     *
     * @return The {@link Component} representing the current tab list suffix or null if none is set.
     */
    Component getTabSuffix(Player player);

    /**
     * Retrieves the current suffix set for players in chat messages.
     *
     * @return The {@link Component} representing the current chat message suffix or null if none is set.
     */
    Component getChatSuffix(Player player);

    /**
     * Retrieves the current custom prefix set for players in the tab list. If you want to get the prefix of the
     * permission group the player is in, use {@link RealmPermissionProvider#primaryRealmGroup(UUID)} for that.
     *
     * @return The {@link Component} representing the current tab list prefix or null if none is set.
     */
    Component getCustomTabPrefix(Player player);

    /**
     * Retrieves the current custom prefix set for players in chat messages. If you want to get the prefix of the
     * permission group the player is in, use {@link RealmPermissionProvider#primaryRealmGroup(UUID)} for that.
     *
     * @return The {@link Component} representing the current chat message prefix or null if none is set.
     */
    Component getCustomChatPrefix(Player player);

}
