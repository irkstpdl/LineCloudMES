package com.lc.view.api.components;

import com.lc.view.api.ComponentState;

/**
 * 表示通用字段组件
 *
 * @since 0.4.0
 */
public interface FieldComponent extends ComponentState {

    /**
     * Checks if field defined by this component is required
     *
     * @return true if field defined by this component is required
     */
    boolean isRequired();

    /**
     * Sets if field is required
     *
     * @param required
     *            true if field should be required
     */
    void setRequired(boolean required);

    /**
     * Checks if field defined by this component is persistent
     *
     * @return true if field defined by this component is persistent
     */
    boolean isPersistent();

    //通知该组件应该更新
    void requestComponentUpdateState();
}
