package com.lc.plugin.api;

import java.util.Collection;

/**
 * Service to accessing plugins registered in the system.
 *
 * @since 0.1.0
 */
public interface PluginAccessor {

    /**
     * Returns plugin with given identifier and status {@link PluginState#ENABLED}.
     *
     * @param identifier
     *            plugin's identifier
     * @return enabled plugin or null if not found
     */
    Plugin getEnabledPlugin(String identifier);

    /**
     * Returns all registered plugins with status {@link PluginState#ENABLED}.
     *
     * @return enabled plugins
     */
    Collection<Plugin> getEnabledPlugins();

    /**
     * Returns plugin with given identifier.
     *
     * @param identifier
     *            plugin's identifier
     * @return plugin or null if not found
     */
    Plugin getPlugin(String identifier);

    /**
     * Returns all registered plugins.
     *
     * @return plugins
     */
    Collection<Plugin> getPlugins();

    /**
     * Returns all system plugins.
     *
     * @return system plugins
     */
    Collection<Plugin> getSystemPlugins();
}
