package de.exceptionflug.realms.api;

import de.exceptionflug.realms.api.model.Group;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * This interface provides access to the realm permission system. Here you can access defined groups and assign players
 * to them.
 *
 * <br><br>
 * Date: 05.07.2021
 * @author Exceptionflug
 */
public interface RealmPermissionProvider {

    /**
     * @return a list of all groups of the realm
     */
    List<Group> groups();

    /**
     * The default group is the base group of every player. Permissions specified in this group are always
     * acting on every player regarding if the player is in another group.
     * @return the default group
     */
    Group defaultGroup();

    /**
     * @return the owner group
     */
    Group ownerGroup();

    /**
     * The booster group will automatically be added to a player when the player has at least <code>n</code> currently
     * active boost(s). The player will automatically be removed from this group when the last active boost of the
     * player expires that is required by this group.
     * @return the booster group
     */
    Group boosterGroup(int boosts);

    /**
     * This returns a list with all groups that can be automatically granted by boosting the realm. Sorted by natural
     * order.
     * @return All booster groups of the realm
     */
    List<Group> boosterGroups();

    /**
     * This method is rate limited.
     * @param groupId the id of the group
     * @return a Set containing the unique ids of all group members
     */
    Action<Set<UUID>> groupMembers(UUID groupId);

    /**
     * Looks for a group with the specified name
     * @param groupName the name to look for
     * @return the first group with the specified name or null if no group was found
     */
    default Group firstGroupWithName(String groupName) {
        return groups().stream().filter(group -> group.name().equals(groupName)).findFirst().orElse(null);
    }

    /**
     * This will return the group with the lowest priority value (the highest group the player has). This group can
     * be used for coloring the player name or other display stuff. This method is using the groupsOfPlayer method. If
     * the used method has been rate limited, it may throw a {@link NullPointerException}.
     *
     * @param playerId the unique id of the player
     * @throws NullPointerException if the groupsOfPlayer method has been blocked due to rate limitation
     * @return the highest group or the default group if the player is in no other group
     */
    default Group primaryRealmGroup(UUID playerId) {
        return groupsOfPlayer(playerId).value().stream().min(Comparator.comparingInt(Group::priority)).orElse(defaultGroup());
    }

    /**
     * Returns all groups a specified player is member of. The result will never contain the default group. This
     * method is rate limited.
     *
     * @param playerId the unique id of the player
     * @return all groups the player is member of
     */
    Action<List<Group>> groupsOfPlayer(UUID playerId);

    /**
     * This method allows you to query the group the player has on Cytooxien. The {@link Group} object contained
     * in the returned {@link Action} will not contain information about permissions. This method is rate limited.
     * @param playerId the unique id of the player
     * @return an Action containing the group of the player
     */
    Action<Group> primaryNetworkGroup(UUID playerId);

    /**
     * This method will add a given player to a given realm group. Please use this method only with custom groups and
     * not with system groups (e.g. owner, default and booster group). This method underlies rate limitation.
     *
     * @param playerId the unique id of the player which should be added to a group
     * @param groupId the id of the group
     * @return an action containing the success state
     */
    Action<Void> addPlayerToGroup(UUID playerId, UUID groupId);

    /**
     * This method will remove a given player from a given realm group. Please use this method only with custom groups and
     * not with system groups (e.g. owner, default and booster group). This method underlies rate limitation.
     *
     * @param playerId the unique id of the player which should be removed from a group
     * @param groupId the id of the group
     * @return an action containing the success state
     */
    Action<Void> removePlayerFromGroup(UUID playerId, UUID groupId);

}
