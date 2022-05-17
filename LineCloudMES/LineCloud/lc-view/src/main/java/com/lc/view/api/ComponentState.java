package com.lc.view.api;

import  java.util.Locale;

/**
 * ComponentState is instance of single view element. It is created by ComponentPattern in request scope.
 * <p>
 * ComponentState contains all informations about state of this component. Changing this data will also change state displayed to
 * system user.
 *
 * @since 0.1.0
 *
 * @see com.lc.view.internal.api.ComponentPattern
 */
public interface ComponentState extends ComponentMessagesHolder{

    /**
     * Type of displayed message.
     */
    public enum MessageType {
        /**
         * Error message,
         */
        FAILURE,
        /**
         * Success message.
         */
        SUCCESS,
        /**
         * Information message.
         */
        INFO
    }

    /**
     * Returns current localization
     *
     * @return current localization
     */
    Locale getLocale();

    /**
     * Sets new value of element defined by this component or do nothing if this component don't contains value
     *
     * @param value
     *            new value of element defined by this component
     */
    void setFieldValue(Object value);

    /**
     * Returns value of element defined by this component or null if this component don't contains value
     *
     * @return value of element defined by this component
     */
    Object getFieldValue();

    /**
     * Returns true if element defined by this component is visible and false if it is hidden.
     *
     * @return true if element defined by this component is visible and false if it is hidden
     */
    boolean isVisible();

    /**
     * Defines if element defined by this component should be visible.
     *
     * @param visible
     *            true if element defined by this component should be visible and false if it should be hidden
     */
    void setVisible(boolean visible);

    /**
     * Returns true if element defined by this component is be enabled
     *
     * @return true if element defined by this component is enabled
     */
    boolean isEnabled();

    /**
     * Defines if element defined by this component should be enabled.
     *
     * @param enable
     *            true if element defined by this component should be enabled
     */
    void setEnabled(boolean enable);

    /**
     * Performs event on this component. <b>For internal usage only</b>
     *
     * @param viewDefinitionState
     *            viewDefinitionState
     * @param event
     *            name of event
     * @param args
     *            arguments of event
     */
    void performEvent(ViewDefinitionState viewDefinitionState, String event, String... args);

    /**
     * Returns true if this component has any error.
     *
     * @return true if this component has any error
     */
    boolean isHasError();

    /**
     * Returns name of this component.
     *
     * @return name of this component
     */
    String getName();

    /**
     * Returns unique identifier of this component.
     *
     * @return unique identifier of this component
     */
    String getUuid();
}
