package de.exceptionflug.realms.api.model;

import net.kyori.adventure.text.Component;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * A group represents an actual permission group.
 *
 * <br><br>
 *
 * Date: 05.07.2021
 * @author Exceptionflug
 */
public class Group {

    private final UUID uniqueId;
    private final String name;
    private final Component prefix;
    private final char color;
    private final int priority;
    private final int requiredBoosts;
    private final Set<String> permissions;

    private Group(UUID uniqueId, String name, Component prefix, char color, int priority, int requiredBoosts, Set<String> permissions) {
        this.uniqueId = uniqueId;
        this.name = name;
        this.prefix = prefix;
        this.color = color;
        this.priority = priority;
        this.requiredBoosts = requiredBoosts;
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return color == group.color && priority == group.priority && uniqueId.equals(group.uniqueId) && name.equals(group.name) && prefix.equals(group.prefix) && permissions.equals(group.permissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueId, name, prefix, color, priority,requiredBoosts, permissions);
    }

    @Override
    public String toString() {
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

    public String name() {
        return name;
    }

    public Component prefix() {
        return prefix;
    }

    public char color() {
        return color;
    }

    public int priority() {
        return priority;
    }

    public Set<String> permissions() {
        return permissions;
    }

    public UUID uniqueId() {
        return uniqueId;
    }

    public static Group create(UUID uuid, String name, Component prefix, char color, int priority, int requiredBoosts, Set<String> permissions) {
        return new Group(uuid, name, prefix, color, priority, requiredBoosts, permissions);
    }

}
