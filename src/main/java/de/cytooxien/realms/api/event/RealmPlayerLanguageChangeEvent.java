package de.cytooxien.realms.api.event;

import de.cytooxien.realms.api.enums.Language;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Event triggered when a player changes their Cytooxien language.
 * Provides access to the old and new language.
 */
public class RealmPlayerLanguageChangeEvent extends PlayerEvent {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    private final Language newLanguage;
    private final Language oldLanguage;

    public RealmPlayerLanguageChangeEvent(@NotNull Player who, @NotNull Language newLanguage, @NotNull Language oldLanguage) {
        super(who);
        this.newLanguage = newLanguage;
        this.oldLanguage = oldLanguage;
    }

    @NotNull
    public Language getNewLanguage() {
        return newLanguage;
    }

    @NotNull
    public Language getOldLanguage() {
        return oldLanguage;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}
