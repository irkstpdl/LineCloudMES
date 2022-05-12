package com.lc.localization.api;

import java.util.Set;

/**
 * Service for getting translation properties for plugin.
 *
 * @since 1.8.0
 */
public interface TranslationPropertiesHolder {

    /**
     * Returns all parsed basenames.
     *
     * @return basenames
     */
    Set<String> getParsedBasenames();

    /**
     * Returns plugin identifier.
     *
     * @return plugin identifier
     */
    String getPluginIdentifier();
}
