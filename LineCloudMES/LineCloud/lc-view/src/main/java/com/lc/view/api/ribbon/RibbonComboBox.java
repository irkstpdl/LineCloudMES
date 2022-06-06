package com.lc.view.api.ribbon;

/**
 * Represents ribbon combo box
 *
 * @since 0.4.0
 */
public interface RibbonComboBox extends RibbonActionItem {

    /**
     * Add new option to this ribbon combo box
     *
     * @param option
     *            option to add
     */
    void addOption(String option);
}
