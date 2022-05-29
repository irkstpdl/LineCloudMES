package com.lc.plugin.api;

/**
 * Servise to managing server.
 *
 * @since 0.1.0
 */
public interface PluginServerManager {

    /**
     * Restarts server.
     *
     * @see PluginOperationStatus#SUCCESS_WITH_RESTART
     */
    void restart();
}
