package de.cytooxien.realms.api.model;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.UUID;

/**
 * A group represents an actual permission group.
 *
 * <br><br>
 * <p>
 * Date: 05.07.2021
 *
 * @author Exceptionflug
 */
public record Group(UUID uniqueId, String name, Component prefix, char color, int priority, int requiredBoosts,
                    Set<String> permissions) {

    public static Group create(UUID uuid, String name, Component prefix, char color, int priority, int requiredBoosts, Set<String> permissions) {
        return new Group(uuid, name, prefix, color, priority, requiredBoosts, permissions);
    }

    @Override
    public @NotNull String toString() {
        return "Group{" +
                "uniqueId=" + uniqueId +
                ", name='" + name + '\'' +
                ", prefix='" + prefix + '\'' +
                ", color=" + color +
                ", priority=" + priority +
                ", requiredBoosts=" + requiredBoosts +
                ", permissions=" + permissions +
                '}';
    }

}
