package com.lc.model.internal.api;

import com.lc.model.api.FieldDefinition;

import java.util.Collection;
import java.util.List;

public interface DefaultValidatorsProvider {

    Collection<FieldHookDefinition>  getMissingValidators(final Iterable<FieldHookDefinition> valiadtors);
}
