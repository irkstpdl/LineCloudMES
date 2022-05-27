package com.lc.plugin.internal.dependencymanager;

/**
 * Service to checking plugin's state.
 *
 * @since 0.1.0
 */

public interface PluginStatusResolver {
    /**
     * Returns true if plugin is enabled.
     *
     * @param pluginIdentifier
     *            plugin's identifier
     * @return true if enabled
     */
    boolean isEnabled(String pluginIdentifier);

    /**
     * Returns true if plugin is enabled.
     *
     * @param plugin
     *            plugin
     * @return true if enabled
     */
    boolean isEnabled(final Plugin plugin);

    /**
     * Returns true if plugin is enabled or enabling.
     *
     * @deprecated for internal use only
     *
     * @param plugin
     *            plugin
     * @return true if enabled or enabling
     */
    @Deprecated
    boolean isEnabledOrEnabling(Plugin plugin);

    /**
     * Returns true if plugin with specified plugin identifier is enabled or enabling.
     *
     * @deprecated for internal use only
     *
     * @param pluginIdentifier
     *            plugin's identifier
     * @return true if enabled or enabling
     */
    @Deprecated
    boolean isEnabledOrEnabling(String pluginIdentifier);
}
