package com.lc.plugin.internal.api;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.lc.plugin.api.Plugin;
import com.lc.plugin.api.PluginDependencyResult;
import com.lc.plugin.internal.dependencymanager.PluginStatusResolver;
import org.springframework.security.core.parameters.P;

public interface PluginDependencyManager {

    PluginDependencyResult getDependenciesToEnable(List<Plugin> plugins,PluginStatusResolver pluginStatusResolver);

    PluginDependencyResult getDependenciesToDisable(List<Plugin> plugins, PluginStatusResolver pluginStatusResolver);

    List<Plugin>sortPluginsInDependencyOrder(Collection<Plugin> plugins);

    List<Plugin> sortPluginsInDependencyOrder(final Collection<Plugin> plugins, final Map<String, Plugin> allPlugins);

    PluginDependencyResult getDependenciesToUninstall(List<Plugin> plugins, PluginStatusResolver pluginStatusResolver);

    PluginDependencyResult getDependenciesToUpdate(Plugin existingPlugin, Plugin newPlugin,
                                                   PluginStatusResolver pluginStatusResolver);
}
