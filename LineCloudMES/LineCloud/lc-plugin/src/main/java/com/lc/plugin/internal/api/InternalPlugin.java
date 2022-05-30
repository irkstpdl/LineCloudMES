package com.lc.plugin.internal.api;

import java.util.List;

import com.lc.plugin.api.Module;
import com.lc.plugin.api.ModuleFactory;
import com.lc.plugin.api.Plugin;
import com.lc.plugin.api.PluginState;

public interface InternalPlugin extends Plugin {
    void changeStateTo(PluginState state);

    List<Module> getModules(ModuleFactory<?> moduleFactory);
}
