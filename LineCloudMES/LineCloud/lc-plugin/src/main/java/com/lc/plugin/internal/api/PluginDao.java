package com.lc.plugin.internal.api;

import java.util.Set;

import com.lc.model.beans.LineCloudPlugin.LineCloudPluginPlugin;
import com.lc.plugin.api.Plugin;
public interface PluginDao {

    void save(LineCloudPluginPlugin plugin);

    void save(Plugin plugin);

    void delete(LineCloudPluginPlugin plugin);

    void delete(Plugin plugin);

    Set<LineCloudPluginPlugin> list();

}
