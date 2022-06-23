package com.lc.view.api.components;

import java.util.List;

import com.lc.model.api.Entity;

/**
 * 动态列表组件
 *
 * @since 1.1.2
 */
public interface AwesomeDynamicListComponent extends FieldComponent {

    /**
     * Returns list of all children form components (rows) of this awesome dynamic list component
     *
     * @return list of all children form components
     */
    List<FormComponent> getFormComponents();

    /**
     * Returns child form component (row) with specified id or null if no such component can be found
     *
     * @param id
     *            id of child form entity
     * @return child form component with specified entity id
     */

    /**
     * Returns child form component (row) with specified id or null if no such component can be found
     *
     * @param id
     *            id of child form entity
     * @return child form component with specified entity id
     */
    FormComponent getFormComponent(Long id);

    /**
     * Returns a list of underlying entities (entity proxies).
     *
     * @return underlying entities (entity proxies).
     *
     * @since 1.3.0
     */
    List<Entity> getEntities();

}
