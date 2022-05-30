package com.lc.plugin.internal.api;

import java.io.File;

import com.lc.plugin.api.artifact.PluginArtifact;

public interface PluginFileManager {

    boolean installPlugin(final  String... filename);

    File uploadPlugin(final PluginArtifact pluginArtifact);

    void unistallPlugin(final String... filename);
}
