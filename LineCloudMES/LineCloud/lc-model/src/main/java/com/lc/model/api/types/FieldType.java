package com.lc.model.api.types;

import java.util.Locale;

import com.lc.model.api.FieldDefinition;
import com.lc.model.internal.api.ValueAndError;

/**
 * Object represents field type.
 */
public interface FieldType {
    /**
     * Returns field class.
     *
     * @return class
     */
    Class<?> getType();

    /**
     * Convert given value to valid field's value defined in {@link FieldType#getType()}. During conversion validation is
     * executed.
     *
     * @param fieldDefinition
     *            field definition
     * @param value
     *            value
     * @return value with validation result
     */
    ValueAndError toObject(FieldDefinition fieldDefinition, Object value);

    /**
     * Convert field's value to string.
     *
     * @param value
     *            value
     * @param locale
     *            locale
     * @return string value
     */
    String toString(Object value, Locale locale);

    /**
     * Convert field's value to object defined in {@link FieldType#getType()}.
     *
     * @param value
     *            value
     * @param locale
     *            locale
     * @return converted value
     */
    Object fromString(String value, Locale locale);

    /**
     * Returns true if field should be copied.
     *
     * @return true if should be copied
     */
    boolean isCopyable();
}
