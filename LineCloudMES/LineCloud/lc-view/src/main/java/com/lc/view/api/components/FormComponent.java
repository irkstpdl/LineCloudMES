package com.lc.view.api.components;

import com.lc.model.api.Entity;
import com.lc.view.api.ComponentState;

/**
 * Represents form component
 *
 * @since 0.1.0
 */

public interface FormComponent extends ComponentState {

    /**
     * 获取此表单实体的 id
     *
     * @return id of entity
     */
    Long getEntityId();

    /**
     * 返回填充此表单值的实体
     *
     * @return entity filled with this forms values
     */
    Entity getEntity();

    /**
     * 从使用此表单值更新的数据库中返回实体。
     * 如果持久化实体不存在（例如在创建期间），则此方法的行为将与 FormComponent getEntity 完全相同。
     * 否则，将使用此表单子组件值获取和更新持久化实体。
     *
     * @return persisted entity with this forms values included
     * @since 1.2.1
     */
    Entity getPersistedEntityWithIncludedFormValues();

    /**
     * Checks if all fields of this form and entity itself are valid
     *
     * @return false when at least one field is not valid, true otherwise
     */
    boolean isValid();

    /**
     * Enables or disables this form and all its inner components
     *
     * @param enabled
     *            true if this form and all its inner components should be enabled, false if disabled
     */
    void setFormEnabled(boolean enabled);

    /**
     * Returns child field component with specified name (first occurence) or null if no such component found
     *
     * @param name
     *            name of component
     * @return field component with specified name
     */
    FieldComponent findFieldComponentByName(String name);

    /**
     * 设置用于填写此表单的实体
     *
     * @param entity
     *            entity which be used to fill form
     * @since 1.1.5
     */
    void setEntity(Entity entity);

}
