package com.lc.model.api;

import com.lc.model.api.validators.ErrorMessage;
import com.lc.model.api.validators.GlobalMessage;

import java.util.List;
import java.util.Map;

public interface EntityMessagesHolder {
    /**
     * Add global info message not related with fields.
     *
     * @param message message
     * @param vars message's vars
     */
    void addGlobalMessage(final String message, final String... vars);

    /**
     * Add global message, not related with fields.
     *
     * @param message message
     * @param autoClose autoClose
     * @param extraLarge extraLarge
     * @param vars message's vars
     */
    void addGlobalMessage(final String message, final boolean autoClose, final boolean extraLarge, final String... vars);

    /**
     * Set global error, not related with fields.
     *
     * @param message
     *            message
     * @param vars
     *            message's vars
     */
    void addGlobalError(final String message, final String... vars);

    /**
     * Set global error, not related with fields.
     *
     * @param message
     *            message
     * @param autoClose
     *            autoClose
     * @param autoClose
     *            autoClose
     * @param vars
     *            message's vars
     */
    void addGlobalError(final String message, final boolean autoClose,final boolean extraLarge, final String... vars);

    /**
     * Set global error, not related with fields.
     *
     * @param message
     *            message
     * @param autoClose
     *            autoClose
     * @param vars
     *            message's vars
     */
    void addGlobalError(final String message, final boolean autoClose, final String... vars);

    /**
     * Set error for given field.
     *
     * @param fieldDefinition
     *            field's definition
     * @param message
     *            message
     * @param vars
     *            message's vars
     */
    void addError(final FieldDefinition fieldDefinition, final String message, final String... vars);

    /**
     * Return all global errors.
     *
     * @return errors
     */
    List<ErrorMessage> getGlobalErrors();

    /**
     * Return all global messages.
     *
     * @return messages
     */
    List<GlobalMessage> getGlobalMessages();

    /**
     * Return all field's errors.
     *
     * @return fields' errors
     */
    Map<String, ErrorMessage> getErrors();

    /**
     * Return error for given field.
     *
     * @param fieldName
     *            field's name
     * @return field's error
     */
    ErrorMessage getError(final String fieldName);
}
