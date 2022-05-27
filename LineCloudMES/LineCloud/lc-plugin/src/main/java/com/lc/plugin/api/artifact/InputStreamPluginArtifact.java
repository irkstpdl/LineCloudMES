package com.lc.plugin.api.artifact;

import java.io.InputStream;

/**
 * Plugin artifact build on raw input stream.
 *
 * @since 0.1.0
 */
public class InputStreamPluginArtifact implements PluginArtifact {

    private final String name;

    private final InputStream inputStream;

    /**
     * Create artifact build on raw input stream.
     *
     * @param name
     *            name of the plugin
     * @param inputStream
     *            input stream
     */

    public InputStreamPluginArtifact(final String name,final InputStream inputStream) {
        this.name = name;
        this.inputStream = inputStream;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public InputStream getInputStream() {
        return inputStream;
    }
}
