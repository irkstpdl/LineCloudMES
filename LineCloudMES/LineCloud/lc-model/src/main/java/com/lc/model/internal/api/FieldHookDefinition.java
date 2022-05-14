package com.lc.model.internal.api;

import com.lc.model.api.DataDefinition;
import com.lc.model.api.Entity;
import com.lc.model.internal.FieldDefinitionImpl;

/**
 * Defines hooks for validation fields.
 */
public interface FieldHookDefinition {

    boolean call(final Entity entity,final  Object oldValue,final Object newValue);

    void initialize(final DataDefinition dataDefinition, FieldDefinitionImpl fieldDefinition);
}
