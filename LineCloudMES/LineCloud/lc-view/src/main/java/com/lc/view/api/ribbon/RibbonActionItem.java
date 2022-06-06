package com.lc.view.api.ribbon;

/**
 * Represents single ribbon item
 *
 * @since 0.1.0
 */
public interface RibbonActionItem {

    /**
     * Type of ribbon item
     */
    public static enum Type {
        /**
         * simple big button
         */
        BIG_BUTTON,
        /**
         * simple small button
         */
        SMALL_BUTTON,
        /**
         * checkbox
         */
        CHECKBOX,
        /**
         * combobox
         */
        COMBOBOX,
        /**
         * small empty space
         */
        SMALL_EMPTY_SPACE
    }

    /**
     * Get defined item click action
     *
     * @return defined item click action
     */
    String getAction();

    /**
     * Get identifier of this ribbon item
     *
     * @return identifier of this ribbon item
     */
    String getName();

    /**
     * Get identifier of this ribbon item
     *
     * @return identifier of this ribbon item
     */
    String getAccesskey();

    /**
     * Get item type
     *
     * @return item type
     */
    Type getType();

    /**
     * Get item icon (null if item without icon)
     *
     * @return item icon
     */
    String getIcon();

    /**
     * Set item icon (null if item without icon)
     *
     * @param icon
     *            item icon
     */
    void setIcon(String icon);

    /**
     * Returns script of this ribbon item
     *
     * @return script of this ribbon item
     */
    String getScript();

    /**
     * Returns true if this item is enabled
     *
     * @return true if this item is enabled
     */
    boolean isEnabled();

    /**
     * Sets this item state
     *
     * @param enabled
     *            true when this item should be enabled or false when this item should be disabled
     */
    void setEnabled(boolean enabled);

    /**
     * Returns message connected to this item
     *
     * @return message connected to this item
     */
    String getMessage();

    /**
     * sets message connected to this item
     *
     * @param message
     *            <b>translation key</b> for new message connected to this item
     */
    void setMessage(String message);

    /**
     * Informs that this item state should be updated
     *
     * @param shouldBeUpdated
     *            true if this item state should be updated
     */
    void requestUpdate(boolean shouldBeUpdated);
}
