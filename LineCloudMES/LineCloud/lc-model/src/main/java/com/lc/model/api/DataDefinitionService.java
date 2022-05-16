package com.lc.model.api;

import java.util.List;

/**
 * Service for manipulating data definitions.
 *
 * @since 0.4.0
 */
public interface DataDefinitionService {

    /**
     * Return the data definition matching the given plugin's identifier and model's name.
     *
     * @param pluginIdentifier
     *            plugin's identifier
     * @param modelName
     *            model's name
     * @return the data definition
     * @throws NullPointerException
     *             if data definition is not found
     */
    DataDefinition get(String pluginIdentifier, String modelName);

    /**
     * Return all defined data definitions.
     *
     * @return the data definitions
     */
    List<DataDefinition> list();
}
