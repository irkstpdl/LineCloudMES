package com.lc.model.api;

import org.apache.commons.lang3.StringUtils;

public final class IntegerUtils {
    private IntegerUtils() {

    }

    /**
     * Converts value, if null returns zero
     *
     * @param value
     *            value
     *
     * @return value or zero
     */
    public static Integer convertNullToZero(final  Object value) {
        if (value == null) {
            return 0;
        }
        if (value instanceof Integer) {
            return (Integer) value;
        }
        return Integer.valueOf(value.toString());
    }

    /**
     * Converts value, if null returns one
     *
     * @param value
     *            value
     *
     * @return value or one
     */

    public static Integer convertNullToOne(final Object value) {
        if (value == null ) {
            return 1;
        }
        if (value instanceof Integer){
            return (Integer) value;
        }
        return Integer.valueOf(value.toString());
    }

    /**
     * Parse integer value from string.
     *
     * @param stringValue
     *            value to be parsed
     * @return parsed integer number or null if given string is empty or blank
     * @throws NumberFormatException
     *             if given string does not represent correct number.
     */
    public static Integer parse(final String stringValue) {
        if (StringUtils.isBlank(stringValue)) {
            return null;
        }
        return Integer.parseInt(StringUtils.trim(stringValue));
    }
}
