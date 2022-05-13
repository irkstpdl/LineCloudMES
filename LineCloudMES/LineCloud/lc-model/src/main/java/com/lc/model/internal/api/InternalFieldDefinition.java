package com.lc.model.internal.api;

import com.lc.model.api.Entity;
import com.lc.model.api.FieldDefinition;

import java.util.Map;

public interface InternalFieldDefinition extends FieldDefinition {

    boolean callValidators(final  Entity entity,final  Object oldValue, final Object newValue);

    boolean isEnabled();

    void enable();

    void disable();

    boolean canBeBothCopyableAndUnique();

}
