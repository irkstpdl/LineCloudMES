package com.lc.plugin.internal.api;

import java.util.List;

import com.lc.plugin.api.ModuleFactory;
import com.lc.plugin.api.Plugin;

public interface ModuleFactoryAccessor {

    void init(List<Plugin> plugins);

    void multiTenantEnable(int tenantId,Plugin plugin);

    void multiTenantDisable(int tenantId, Plugin plugin);

    List<ModuleFactory<?>> getModuleFactories();

    ModuleFactory<?> getModuleFactory(String identifier);
}
