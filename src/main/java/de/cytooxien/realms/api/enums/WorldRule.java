package de.cytooxien.realms.api.enums;

/**
 * Date: 08.10.2021
 *
 * @author Exceptionflug
 */
public enum WorldRule {

    WEATHER_RHYTHM("weather_rhythm"),
    WEATHER_LIGHTNING("weather_lightning"),
    DAYLIGHT_CYCLE("daylight_cycle"),
    PVP("pvp"),
    PLAYER_DAMAGE("player_damage"),
    FALL_DAMAGE("falldamage"),
    BLOCK_DAMAGE_FRIENDLY("blockdamage_friendly"),
    BLOCK_DAMAGE_HOSTILE("blockdamage_hostile"),
    BLOCK_DAMAGE_TNT("blockdamage_tnt"),
    FIRE_SPREAD("firespread"),
    KEEP_INVENTORY("keep_inventory"),
    NATURAL_REGENERATION("natural_regeneration"),
    NATURAL_HUNGER("natural_hunger"),
    INSOMNIA("insomnia");

    private final String internalName;

    WorldRule(String internalName) {
        this.internalName = internalName;
    }

    public String internalName() {
        return internalName;
    }
}
