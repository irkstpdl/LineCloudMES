package com.lc.model.api;

import java.util.Locale;

import com.lc.model.api.types.FieldType;
/**
 * Object defines database field.
 *
 * @since 0.4.0
 */
public interface FieldDefinition {

    /**
     * Return field's name.
     *
     * @return field's name
     */
    String getName();

    /**
     * Convert value to string.
     *
     * @param value
     *            value
     * @param locale
     *            locale
     * @return string or null
     * @see FieldType#toString(Object, Locale)
     */
    String getValue(final Object value,Locale locale);

    /**
     * Return field's type.
     *
     * @return field's type
     */
    FieldType getType();

    /**
     * Return true if this field is readonly.
     *
     * @return is readonly
     */
    boolean isReadOnly();

    /**
     * Return true if this field is required.
     *
     * @return is required
     */
    boolean isRequired();

    /**
     * Return default value for this field.
     *
     * @return default value
     */
    Object getDefaultValue();

    /**
     * Return true if this field is unique.
     *
     * @return is unique
     */
    boolean isUnique();

    /**
     * Return true if this field is persistent (will be saved in database).
     *
     * @return is persistent
     */
    boolean isPersistent();

    /**
     * Get expression to get the field value.
     *
     * @return expression
     */
    String getExpression();

    /**
     * Return data definition which this field belongs to.
     *
     * @return data definition
     */
    DataDefinition getDataDefinition();
}
