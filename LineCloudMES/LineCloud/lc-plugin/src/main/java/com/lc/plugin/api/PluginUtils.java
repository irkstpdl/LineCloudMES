package com.lc.plugin.api;

import com.lc.plugin.internal.PluginUtilsService;

/**
 * Utils to checking plugin's state.
 *
 * @since 0.1.0
 */
public final class PluginUtils {

    private PluginUtils() {

    }

    /**
     * Returns true if plugin is enabled.
     *
     * @param plugin
     *            plugin
     * @return true if enabled
     * @see PluginStateResolver#isEnabled(Plugin)
     */
    public static boolean isEnabled(final Plugin plugin) {
        return PluginUtilsService.isEnabled(plugin);
    }

    /**
     * Returns true if plugin is enabled.
     *
     * @param pluginIdentifier
     *            plugin's identifier
     * @return true if enabled
     * @see PluginStateResolver#isEnabled(String)
     */
    public static boolean isEnable(final String pluginIdentifier) {
        return PluginUtilsService.isEnabled(pluginIdentifier);
    }

    /**
     * Returns true if plugin is enabled or enabling.
     *
     * @deprecated for internal use only
     *
     * @param plugin
     *            plugin
     * @return true if enabled or enabling
     * @see PluginStateResolver#isEnabledOrEnabling(Plugin)
     */
    @Deprecated
    public static boolean isEnabledOrEnabling(final Plugin plugin) {
        return PluginUtilsService.isEnabledOrEnabling(plugin);
    }

    /**
     * Returns true if plugin is enabled or enabling.
     *
     * @deprecated for internal use only
     *
     * @param pluginIdentifier
     *            plugin's identifier
     * @return true if enabled or enabling
     * @see PluginStateResolver#isEnabledOrEnabling(Plugin)
     */
    @Deprecated
    public static boolean isEnabledOrEnabling(final String pluginIdentifier) {
        return PluginUtilsService.isEnabledOrEnabling(pluginIdentifier);
    }
}
