package com.lc.view.api.ribbon;

import java.util.List;

import com.lc.security.api.SecurityRole;
/**
 * Represents ribbon items group
 *
 * @since 0.1.0
 */
public interface RibbonGroup {

    /**
     * Get identifier of this ribbon group
     *
     * @return identifier of this ribbon group
     */
    String getName();

    /**
     * Returns default authorization role necessary to be able to see this ribbon group or null if no such role defined
     *
     * @return default authorization role
     */
    SecurityRole getAuthorizationRole();

    /**
     * Get items of this group
     *
     * @return items of this group
     */
    List<RibbonActionItem> getItems();

    /**
     * Get item by name
     *
     * @return item or null when no item witch such name
     */
    RibbonActionItem getItemByName(final String itemName);
}
