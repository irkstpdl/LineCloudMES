package com.lc.model.api.validators;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * Object holds validation messages.
 *
 */
public final class GlobalMessage {

    private final String message;

    private final String [] vars;

    private final boolean autoClose;

    private final boolean extraLarge;

    /**
     * Create new validation error message.
     *
     * @param message
     *            message
     * @param vars
     *            message's vars
     */
    public GlobalMessage(final String message, final String... vars) {
        this.message = message;
        this.autoClose = true;
        this.extraLarge = false;
        if (ArrayUtils.isEmpty(vars)) {
            this.vars = ArrayUtils.EMPTY_STRING_ARRAY;
        } else {
            this.vars = vars;
        }
    }

    /**
     * Create new validation error message.
     *
     * @param message
     *            message
     * @param autoClose
     *            autoClose
     * @param vars
     *            message's vars
     */
    public GlobalMessage(final String message,final boolean autoClose,final String... vars) {
        this.message =message;
        this.autoClose = autoClose;
        this.extraLarge = false;
        if (ArrayUtils.isEmpty(vars)) {
            this.vars = ArrayUtils.EMPTY_STRING_ARRAY;
        } else {
            this.vars =vars;
        }
    }

    /**
     * Create new validation error message.
     *
     * @param message
     *            message
     * @param autoClose
     *            autoClose
     * @param extraLarge
     *            extraLarge
     * @param vars
     *            message's vars
     */
    public GlobalMessage(final String message, final boolean autoClose, final boolean extraLarge, final String... vars) {
        this.message = message;
        this.autoClose = autoClose;
        this.extraLarge = extraLarge;
        if (ArrayUtils.isEmpty(vars)) {
            this.vars = ArrayUtils.EMPTY_STRING_ARRAY;
        } else {
            this.vars = vars;
        }
    }

    /**
     * Return validation error message.
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Return validation error message's vars.
     *
     * @return message's vars
     */
    public String[] getVars() {
        return Arrays.copyOf(vars, vars.length);
    }

    /**
     * Return autoClose.
     *
     * @return autoClose
     */
    public boolean getAutoClose() {
        return autoClose;
    }

    /**
     * Return extraLarge.
     *
     * @return extraLarge
     */
    public boolean isExtraLarge() {
        return extraLarge;
    }
}
