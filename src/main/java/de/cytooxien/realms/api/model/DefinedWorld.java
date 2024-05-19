package de.cytooxien.realms.api.model;

import de.cytooxien.realms.api.world.WorldPreset;
import de.cytooxien.realms.api.world.WorldRule;

import java.io.File;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Date: 08.10.2021
 *
 * @author Exceptionflug
 */
public class DefinedWorld {

    private final UUID uniqueId;
    private final String displayName;
    private final File worldFolder;
    private final boolean loaded;
    private final WorldPreset preset;
    private final Map<WorldRule, Boolean> rules;

    private DefinedWorld(UUID uniqueId, String displayName, File worldFolder, boolean loaded, WorldPreset preset, Map<WorldRule, Boolean> rules) {
        this.uniqueId = uniqueId;
        this.displayName = displayName;
        this.worldFolder = worldFolder;
        this.loaded = loaded;
        this.preset = preset;
        this.rules = rules;
    }

    public static DefinedWorld create(UUID uniqueId, String displayName, File worldFolder, boolean loaded,
                                      WorldPreset preset, Map<WorldRule, Boolean> rules) {
        return new DefinedWorld(uniqueId, displayName, worldFolder, loaded, preset, rules);
    }

    public UUID uniqueId() {
        return uniqueId;
    }

    public String displayName() {
        return displayName;
    }

    public File worldFolder() {
        return worldFolder;
    }

    public boolean loaded() {
        return loaded;
    }

    public WorldPreset preset() {
        return preset;
    }

    public Map<WorldRule, Boolean> rules() {
        return rules;
    }

    @Override
    public String toString() {
        return "DefinedWorld{" +
                "uniqueId=" + uniqueId +
                ", displayName='" + displayName + '\'' +
                ", worldFolder=" + worldFolder +
                ", loaded=" + loaded +
                ", preset=" + preset +
                ", rules=" + rules +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefinedWorld that = (DefinedWorld) o;
        return loaded == that.loaded && uniqueId.equals(that.uniqueId) && displayName.equals(that.displayName) && worldFolder.equals(that.worldFolder) && preset == that.preset && rules.equals(that.rules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueId, displayName, worldFolder, loaded, preset, rules);
    }
}
