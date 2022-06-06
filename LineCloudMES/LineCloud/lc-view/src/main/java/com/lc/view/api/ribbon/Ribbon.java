package com.lc.view.api.ribbon;

/**
 * Represents ribbon in application
 *
 * @since 0.1.0
 */
public interface Ribbon {

    /**
     * Get identifier of this ribbon
     *
     * @return identifier of this ribbon
     */
    String getName();

    /**
     * Get groups of this ribbon
     *
     * @return groups of this ribbon
     */
    List<RibbonGroup> getGroups();

    /**
     * Get group by name of this ribbon
     *
     * @return group or null when no group witch such name
     */

    RibbonGroup getGroupByName(String groupName);
}
