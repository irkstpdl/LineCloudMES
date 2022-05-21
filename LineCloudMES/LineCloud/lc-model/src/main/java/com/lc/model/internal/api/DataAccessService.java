package com.lc.model.internal.api;

import com.lc.model.api.Entity;
import com.lc.model.api.EntityOpResult;
import com.lc.model.api.search.SearchResult;
import com.lc.model.internal.DataAccessServiceImpl;
import com.lc.model.internal.DataDefinitionImpl;
import com.lc.model.internal.search.SearchCriteria;
import com.lc.model.internal.search.SearchQuery;

import java.util.List;

/**
 * Service for manipulating data.
 *
 * @since 0.1.0
 *
 */
public interface DataAccessService {

    /**
     * Return dataDefinition for given pluginIdentifier and name
     *
     * @param pluginIdentifier
     * @param name
     * @return the data definition
     */
    InternalDataDefinition getDataDefinition(String pluginIdentifier, String name);

    /**
     * Save the entity related with given data definition.
     *
     * @param dataDefinition
     * @param entity
     * @return saved entity
     */
    Entity save(InternalDataDefinition dataDefinition, Entity entity);

    /**
     * Validate the entity related with given data definition.
     *
     * @param dataDefinition
     * @param entity
     * @return validated entity
     */
    Entity validate(DataDefinitionImpl dataDefinition, Entity entity);

    /**
     * Save the entity related with given data definition without invoke hooks.
     *
     * @param dataDefinition
     * @param entity
     * @return saved entity
     */
    Entity fastSave(InternalDataDefinition dataDefinition, Entity entity);

    /**
     * Return the entity related with given data definition, by its id.
     *
     * @param dataDefinition
     * @param entityId
     * @return entity
     */
    Entity get(InternalDataDefinition dataDefinition, Long entityId);

    /**
     * Return the entity related with master model data definition, by its id.
     *
     * @param dataDefinition
     * @param id
     * @return entity
     */
    Entity getMasterModelEntity(InternalDataDefinition dataDefinition, final Long id);

    /**
     * Return the copied entity related with given data definition.
     *
     * @param dataDefinition
     * @param entityId
     * @return entity
     */
    List<Entity> copy(InternalDataDefinition dataDefinition, Long... entityId);

    /**
     * Delete the entity related with given data definition, by its id.
     *
     * @param dataDefinition
     * @param entityId
     * @return {@link EntityOpResult} which represent deletion results
     */
    EntityOpResult delete(InternalDataDefinition dataDefinition, Long... entityId);

    /**
     * Find search result for given search criteria.
     *
     * @param searchCriteria
     * @return result of search
     */
    SearchResult find(SearchCriteria searchCriteria);

    /**
     * Find search result for given search query.
     *
     * @param searchQuery
     * @return result of search
     */
    SearchResult find(SearchQuery searchQuery);

    /**
     * Move the prioritizable entity to the target position.
     *
     * @param dataDefinition
     * @param entityId
     * @param position
     */
    void moveTo(InternalDataDefinition dataDefinition, Long entityId, int position);

    /**
     * Move the prioritizable entity by offset.
     *
     * @param dataDefinition
     * @param entityId
     * @param offset
     */
    void move(InternalDataDefinition dataDefinition, Long entityId, int offset);

    /**
     * Convert given entity to database entity.
     *
     * @param entity
     * @return database entity
     */
    Object convertToDatabaseEntity(Entity entity);

    /**
     * Deactivate given entities.
     *
     * @param dataDefinition
     * @param entityId
     * @return deactivated entities
     */
    List<Entity> deactivate(InternalDataDefinition dataDefinition, Long... entityId);

    /**
     * Activate given entities.
     *
     * @param dataDefinition
     * @param entityId
     * @return activated entities
     */
    List<Entity> activate(InternalDataDefinition dataDefinition, Long... entityId);
}
