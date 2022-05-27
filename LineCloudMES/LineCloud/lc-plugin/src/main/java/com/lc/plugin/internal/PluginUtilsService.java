package com.lc.plugin.internal;

import javax.annotation.PostConstruct;

import com.lc.plugin.api.Plugin;
import com.lc.plugin.internal.dependencymanager.PluginStatusResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;

/**
 * Utils to checking plugin's state.
 *
 * @since 0.1.0
 */
@Service
public class PluginUtilsService {

    private final PluginStatusResolver pluginStatusResolver;

    public static PluginUtilsService instance;

    @Autowired
    public  PluginUtilsService(final PluginStatusResolver pluginStatusResolver) {
        this.pluginStatusResolver = pluginStatusResolver;
    }

    @PostConstruct
    public void init() {
        initialise(this);
    }

    private static void initialise(final PluginUtilsService pluginUtil) {
        PluginUtilsService.instance = pluginUtil;
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
        return  instance.pluginStatusResolver.isEnabled(plugin);
    }

    /**
     * Returns true if plugin is enabled.
     *
     * @param pluginIdentifier
     *            plugin's identifier
     * @return true if enabled
     * @see PluginStateResolver#isEnabled(String)
     */

    public static boolean isEnabled(final String pluginIdentifier) {
        return instance.pluginStatusResolver.isEnabled(pluginIdentifier);
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
        return instance.pluginStateResolver.isEnabledOrEnabling(plugin);
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
        return instance.pluginStateResolver.isEnabledOrEnabling(pluginIdentifier);
    }


}
