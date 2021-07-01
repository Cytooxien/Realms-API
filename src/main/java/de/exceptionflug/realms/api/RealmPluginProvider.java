package de.exceptionflug.realms.api;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import java.util.Collection;

/**
 * Realms is managing user plugins using a different {@link PluginManager} as the one you get by
 * calling Bukkit.getPluginManager(). This interface let's you access this {@link PluginManager}.
 * <br><br>
 * Date: 01.07.2021
 * @author Exceptionflug
 */
public interface RealmPluginProvider {

    /**
     * Realms are using multiple {@link PluginManager}s. This one returned here is the one used for loading
     * predefined and custom user plugins.
     *
     * @return the plugin manager used for loading predefined and custom user plugins.
     */
    PluginManager pluginManager();

    /**
     * When there are more plugins installed than the limit allows, some plugins won't get enabled. You can
     * see the list of plugins which were not enabled during startup. This method returns a collection of those plugins.
     *
     * @return a collection with plugins there were not enabled during startup
     */
    Collection<Plugin> notEnabledPlugins();

}
