package com.lc.plugin.api.artifact;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Plugin artifact build on JAR file.
 *
 * @since 0.1.0
 */
public final class JarPluginArtifact implements PluginArtifact {

    private final File file;

    /**
     * Create artifact build on JAR file.
     *
     * @param file
     *            JAR file
     * @throws IllegalStateException
     *             if file doesn't exists or cannot be read
     */
    public JarPluginArtifact(final File file) {
        if (!file.exists() || !file.canRead()) {
            throw new IllegalStateException("不能读取文件" + file.getAbsolutePath());
        }
        this.file = file;
    }

    @Override
    public String getName() {
        return  file.getName();
    }

    @Override
    public InputStream getInputStream() {
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new IllegalStateException(e.getMessage(),e);
        }
    }
}
