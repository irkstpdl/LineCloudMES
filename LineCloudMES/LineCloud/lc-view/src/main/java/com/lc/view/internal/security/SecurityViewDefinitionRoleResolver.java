package com.lc.view.internal.security;


//import com.lc.security.api.SecurityRole;

import org.apache.tomcat.util.descriptor.web.SecurityRoleRef;

/**
 * Interface for service that will provide information about access role of view definitions.
 *
 * @since 0.1.0
 */
public interface SecurityViewDefinitionRoleResolver {


    /**
     * Gets access role of view definition
     *
     * @param pluginIdentifier
     *            plugin identifier of view definition
     * @param viewName
     *            name of view definition
     * @return security role of view definition - can be null if no role defined to this view
     */
    SecurityRole getRoleForView(String pluginIdentifier, String viewName);
}
