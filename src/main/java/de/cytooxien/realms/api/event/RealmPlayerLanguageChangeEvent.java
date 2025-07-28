package de.cytooxien.realms.api.event;

import de.cytooxien.realms.api.enums.Language;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/**
 * This is an event which gets called when a player changes their Cytooxien language.
 */
public class RealmPlayerLanguageChangeEvent extends PlayerEvent {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    private Language newLanguage;
    private Language oldLanguage;

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
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}
