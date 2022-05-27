package com.lc.model.internal.hooks;

import org.springframework.context.ApplicationContext;

import com.lc.model.api.DataDefinition;
import com.lc.model.api.Entity;
import com.lc.model.internal.api.EntityHookDefinition;
import com.lc.plugin.api.PluginUtils;
public final class EntityHookDefinitionImpl extends AbstractModelHookDefinition implements EntityHookDefinition {

    private boolean enabled = true;

    public EntityHookDefinitionImpl(final String className, final String methodName, final String pluginIdentifier,
                                    final ApplicationContext applicationContext) throws HookInitializationException {
        super(className, methodName, pluginIdentifier, applicationContext);
    }

    @Override
    public String getName() {
        return getBean().getClass().getCanonicalName().split("\\$\\$")[0] + "." + getMethod().getName();
    }

    @Override
    public boolean call(final Entity entity) {
        return call(getDataDefinition(), entity);
    }

    @Override
    public Class<?>[] getParameterTypes() {
        return new Class[] { DataDefinition.class, Entity.class };
    }

    @Override
    public boolean isEnabled() {
        return enabled && PluginUtils.isEnabledOrEnabling(getPluginIdentifier());
    }

    @Override
    public void enable() {
        enabled = true;
    }

    @Override
    public void disable() {
        enabled = false;
    }

}