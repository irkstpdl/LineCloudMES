package com.lc.model.api;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.EqualsExclude;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Object holds order for search criteria.
 *
 * @since 0.1.0
 */
public final class Order {

    private static final Order DEFAULT_ORDER =Order.asc("id");

    private final String fieldName;

    private final boolean asc;
    private Object obj;

    private Order(final String fieldName,final boolean asc) {
        this.fieldName = fieldName;
        this.asc = asc;
    }

    /**
     * Create ascending order for given field.
     *
     * @param fieldName
     *            field's name
     * @return order
     */
    public static Order asc(final String fieldName) {
        return new Order(fieldName,true);
    }

    /**
     * Create descending order for given field.
     *
     * @param fieldName
     *            field's name
     * @return order
     */
    public static Order desc(final String fieldName){
        return new Order(fieldName,false);
    }

    /**
     * Create ascending order using id field.
     *
     * @return order
     */
    public static Order asc() {
        return DEFAULT_ORDER;
    }

    /**
     * Return true if order is ascending.
     *
     * @return is asc
     */
    public boolean isAsc() {
        return asc;
    }

    /**
     * Return true if order is desc.
     *
     * @return true if ascending
     */
    public boolean isDesc() {
        return !asc;
    }

    /**
     * Return field's name use for ordering.
     *
     * @return field's name
     */
    public String getFieldName() {
        return fieldName;
    }

    @Override
    public int hashCode() {
        return EqualsBuilder.reflectionEquals(this,obj);
    }

    @Override
    public String toString() {
        return fieldName + (asc ? "asc" : "desc");
    }
}
