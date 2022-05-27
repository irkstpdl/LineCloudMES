package com.lc.plugin.api.artifact;

import java.io.InputStream;

/**
 * Abstraction which represents location of the plugin.
 *
 * @since 0.1.0
 */
public interface PluginArtifact {

    /**
     * Name of the plugin, will be used to create filename.
     *
     * @return name of the plugin
     */
    String getName();

    /**
     * Stream containing the jar with plugin.
     *
     * @return stream
     */
    InputStream getInputStream();
}
