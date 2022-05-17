package com.lc.view.api.utils;

import com.lc.model.api.Entity;
import com.lc.view.api.components.FormComponent;

/**
 * Helper class for Form
 *
 * @deprecated
 */
@Deprecated
public final class FormUtils {

    private FormUtils() {

    }

    /**
     * Set Entity which be used to fill this form
     *
     * @deprecated this method is deprecated, if you want set form's entity, use {@link FormComponent#setEntity(Entity)}
     *
     * @param form
     *            form which want to fill
     * @param entity
     *            entity which be used to fill form
     */
    @Deprecated
    public static void setFormEntity(final FormComponent form,final Entity entity) {
        form.setEntity(entity);
    }
}
