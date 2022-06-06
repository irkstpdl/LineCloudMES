package com.lc.view.api.ribbon;

import java.util.List;

/**
 * Represents ribbon item that contains dropdown submenu with other items
 *
 * @since 0.4.0
 */
public interface RibbonComboItem extends RibbonActionItem {

    /**
     * Get list of dropdown items
     *
     * @return list of dropdown items
     */
    List<RibbonActionItem> getItems();

}