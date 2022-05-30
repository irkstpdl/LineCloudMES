package com.lc.plugin.internal.api;

import java.io.File;
import java.util.Set;

import org.springframework.core.io.Resource;

public interface PluginDescriptorParser {

    /**
     * Parse a plugin from the classpath
     *
     * @param resource
     *            plugins descriptor in the classpath
     */
    InternalPlugin parse(final Resource resource);

    /**
     * Parse a plugin from outside the classpath
     *
     * @param file
     *            plugin file
     */
    InternalPlugin parse(final File file);

    /**
     * Load enabled plugins
     */
    Set<InternalPlugin> loadPlugins();

    /**
     * Temporary plugins waiting for install
     */
    Set<InternalPlugin> getTemporaryPlugins();
}
