package com.lc.model.api;

import java.util.List;

import com.lc.model.api.search.SearchCriteriaBuilder;

/**
 * Object represents list of entities from hasMany relation.
 *
 * @since 0.1.0
 * @see Entity#getHasManyField(String)
 */
public interface EntityList extends List<Entity> {

    /**
     * Creates search criteria builder for this entities' data definition - it will be automatically restricted with hasMany
     * relation.
     *
     * @see DataDefinition#find()
     * @return new search criteria builder
     */
    SearchCriteriaBuilder find();
}
