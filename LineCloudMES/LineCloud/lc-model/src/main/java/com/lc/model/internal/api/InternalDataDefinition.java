package com.lc.model.internal.api;

import com.lc.model.api.Entity;
import com.lc.model.api.DataDefinition;
import com.lc.model.internal.MasterModel;
import com.lc.model.internal.search.SearchCriteria;

import javax.naming.directory.SearchResult;
import java.util.Map;
/**
 * Object defines database structure. This is {@link DataDefinition} extension for internal usage.
 */
public interface InternalDataDefinition extends DataDefinition {

    /**
     * Find endities for this data definition using given search criteria.
     *
     * @param searchCriteria
     *            search criteria
     * @return search result
     */
    SearchResult find(final  SearchCriteria searchCriteria);

    /**
     * Get fully qualified class name representing given data definition.
     *
     * @return fully qualified class name
     */
    String getFullyQualifiedClassName();

    /**
     * Call view hooks on given entity.
     *
     * @param entity
     *            entity
     */
    boolean callViewHook(final Entity entity);

    /**
     * Call create hooks on given entity.
     *
     * @param entity
     *            entity
     */
    boolean callCreateHook(final Entity entity);

    /**
     * Call update hooks on given entity.
     *
     * @param entity
     *            entity
     */
    boolean callUpdateHook(final Entity entity);

    /**
     * Call save hooks on given entity.
     *
     * @param entity
     *            entity
     */
    boolean callSaveHook(final Entity entity);

    /**
     * Call delete hooks on given entity.
     *
     * @param entity
     *            entity
     */
    boolean callDeleteHook(Entity entity);

    /**
     * Get class representing given data definition.
     *
     * @see #getFullyQualifiedClassName()
     * @return class
     */
    Class<?> getClassForEntity();

    /**
     * Get new instance of class representing given data definition.
     *
     * @see #getClassForEntity()
     * @return new entity instance
     */
    Object getInstanceForEntity();

    /**
     * Return true if entity of given data definition can be deleted.
     *
     * @return is deletable
     */
    boolean isDeletable();

    /**
     * Return true if entity of given data definition can be created.
     *
     * @return is creatable
     */
    boolean isInstertable();

    /**
     * Return true if entity of given data definition can be updated.
     *
     * @return is updatable
     */
    boolean isUpdatable();

    /**
     * Return true if entity of given data definition can be audited.
     *
     * @return is auditable
     */
    boolean isAuditable();

    /**
     * Call copy hooks on given entity.
     *
     * @param targetEntity
     *            entity
     */
    boolean callCopyHook(Entity targetEntity);

    EntityHookDefinition getHook(String type, String className, String methodName);

    String getIdentifierExpression();

    boolean isEnabled();

    void enable();

    void disable();

    MasterModel getMasterModel();

    void setMasterModel(MasterModel masterModel);
}
