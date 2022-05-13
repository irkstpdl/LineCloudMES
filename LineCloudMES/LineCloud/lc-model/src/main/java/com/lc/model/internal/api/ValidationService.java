package com.lc.model.internal.api;

import com.lc.model.api.Entity;

/**
 * Service for entity validation, parsing fields and calling model hooks
 */
public interface ValidationService {

    /**
     * Parse, validate given entity and call model hooks.
     *
     * @param dataDefinition
     *            model data definition for validated entity
     * @param genericEntity
     *            entity to be validated
     * @param existingGenericEntity
     *            existing entity, might be null if validated entity is currently created
     */
    void validateGenericEntity(InternalFieldDefinition dataDefinition,Entity genericEntity,Entity existingGenericEntity);
}
