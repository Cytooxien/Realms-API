package de.exceptionflug.realms.api;

import de.exceptionflug.realms.api.model.DefinedWorld;
import de.exceptionflug.realms.api.world.WorldRule;
import org.bukkit.World;

import java.util.List;
import java.util.UUID;

/**
 * Date: 08.10.2021
 *
 * @author Exceptionflug
 */
public interface RealmWorldProvider {

    /**
     * @return All defined worlds of the world system
     */
    List<DefinedWorld> definedWorlds();

    /**
     * Iterates over all defined worlds and returns the first world with a matching display name.
     * @param displayName The display name to search for
     * @return An instance of DefinedWorld or null if no world with that requirement was found
     */
    default DefinedWorld definedWorldByDisplayName(String displayName) {
        for (DefinedWorld world : definedWorlds()) {
            if (world.displayName().equals(displayName)) {
                return world;
            }
        }
        return null;
    }

    /**
     * Iterates over all defined worlds and returns the first world with a matching internal name.
     * @param internalName The name to search for (world folder name)
     * @return An instance of DefinedWorld or null if no world with that requirement was found
     */
    default DefinedWorld definedWorldByName(String internalName) {
        for (DefinedWorld world : definedWorlds()) {
            if (world.worldFolder().getName().equals(internalName)) {
                return world;
            }
        }
        return null;
    }

    /**
     * Iterates over all defined worlds and returns the first world with a matching unique id.
     * @param uniqueId The unique id to search for
     * @return An instance of DefinedWorld or null if no world with that requirement was found
     */
    default DefinedWorld definedWorldByUniqueId(UUID uniqueId) {
        for (DefinedWorld world : definedWorlds()) {
            if (world.uniqueId().equals(uniqueId)) {
                return world;
            }
        }
        return null;
    }

    /**
     * This will unload a world and will mark it as unloaded in the world system. If the world is already unloaded,
     * nothing will happen. All players on the world will be teleported to the default world.
     * @param uniqueId The unique id of the world to unload
     */
    void unloadWorld(UUID uniqueId);

    /**
     * This will load an unloaded world and will mark the world as loaded in the world system. If the world is already
     * loaded, the instance of the loaded world will directly be returned.
     * @param uniqueId The unique id of the world to load
     * @return The loaded bukkit world instance or null if the world could not be loaded
     */
    World loadWorld(UUID uniqueId);

    /**
     * This will completely delete a world from the realm. If the world is currently loaded, it will be automatically
     * unloaded.
     * @param uniqueId The unique id of the world to delete
     */
    void deleteWorld(UUID uniqueId);

    /**
     * This will update the value of a rule.
     * @param uniqueId The unique id of the world
     * @param rule The rule to update
     * @param value The new value of that rule
     */
    void updateRule(UUID uniqueId, WorldRule rule, boolean value);

}
