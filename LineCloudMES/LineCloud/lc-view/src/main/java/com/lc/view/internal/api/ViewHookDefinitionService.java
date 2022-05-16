package com.lc.view.internal.api;

import java.util.List;

/**
 * Service for manipulating view definitions.
 *
 * @since 0.1.0
 */

public interface ViewHookDefinitionService {

    /**
     * Return the view definition matching the given plugin's identifier and view's name. The method checks if user has sufficient
     * permissions.
     *
     * @param pluginIdentifier
     *            plugin's identifier
     * @param viewName
     *            view's name
     * @return the view definition, null if not found
     */
    ViewDefinition get(String pluginIdentifier,String viewName);

    /**
     * Return all defined view definitions.
     *
     * @return the data definitions
     */
    List<ViewDefinition> list();

    /**
     * Check if view exists.
     *
     * @return true if view exists, false otherwise
     */
    boolean viewExists(String pluginIdentifier,String viewName);

}
