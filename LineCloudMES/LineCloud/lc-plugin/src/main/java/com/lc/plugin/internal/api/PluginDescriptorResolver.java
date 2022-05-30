package com.lc.plugin.internal.api;

import org.springframework.core.io.Resource;

public interface PluginDescriptorResolver {

    /**
     * Descriptors of enabled plugins
     */
    Resource[] getDescriptors();

}
