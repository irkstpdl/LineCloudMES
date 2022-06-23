package com.lc.view.api.components;

/**
 * CheckBox component
 *
 * @author PhiliphG
 * @since 1.2.1
 */
public interface CheckBoxComponent extends FieldComponent {

    /**
     * Mark this component as (un)checked.
     *
     * @param value
     *            true if you want to mark this component as checked.
     */
    void setChecked(final boolean value);

    /**
     * Check if this component is checked
     *
     * @return true if this component is checked
     */
    boolean isChecked();

}