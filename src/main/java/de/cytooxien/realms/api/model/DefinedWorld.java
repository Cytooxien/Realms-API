package de.cytooxien.realms.api.model;

import de.cytooxien.realms.api.enums.WorldPreset;
import de.cytooxien.realms.api.enums.WorldRule;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Map;
import java.util.UUID;

/**
 * Date: 08.10.2021
 *
 * @author Exceptionflug
 */
public record DefinedWorld(UUID uniqueId, String displayName, File worldFolder, boolean loaded, WorldPreset preset,
                           Map<WorldRule, Boolean> rules) {

    public static DefinedWorld create(UUID uniqueId, String displayName, File worldFolder, boolean loaded,
                                      WorldPreset preset, Map<WorldRule, Boolean> rules) {
        return new DefinedWorld(uniqueId, displayName, worldFolder, loaded, preset, rules);
    }

    @Override
    public @NotNull String toString() {
        return "DefinedWorld{" +
                "uniqueId=" + uniqueId +
                ", displayName='" + displayName + '\'' +
                ", worldFolder=" + worldFolder +
                ", loaded=" + loaded +
                ", preset=" + preset +
                ", rules=" + rules +
                '}';
    }
}
