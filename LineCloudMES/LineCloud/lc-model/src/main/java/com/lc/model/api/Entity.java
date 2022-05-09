package com.lc.model.api;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Object represents data from the database tables. All fields are aggregated
 * into key-value map. The key is the name of the field from its definition -
 * {@link com.lc.model.api.FieldDefinition#getName()}.
 *
 * @since 0.4.0
 */

public interface Entity extends EntityMessagesHolder {
    /**
     * Set the entity's id.
     *
     * @param id the entity's name
     */
    void setId(Long id);

    /**
     * Return the entity's id.
     *
     * @return the entity's id
     */
    Long getId();

    /**
     * Return the entity's dataDefinition.
     *
     * @return the entity's dataDefinition
     */
    DataDefinition getDataDefinition();

    /**
     * Return the value of the field with given name.
     *
     * @param fieldName field's name
     * @return the field's value
     */
    Object getField(String fieldName);

    /**
     * Return the value, casted to string, of the field with given name.
     *
     * @param fieldName field's name
     * @return the field's value
     */
    String getStringField(String fieldName);

    /**
     * Return the boolean value of the field with given name
     *
     * @param fieldName field's name
     * @return the field's boolean value
     */
    boolean getBooleanField(String fieldName);

    /**
     * Return the decimal (java.math.BigDecimal) value of the field with given
     * name
     *
     * @param fieldName field's name
     * @return the field's decimal value
     *
     * @throws IllegalArgumentException if given field is not BigDecimal
     * (sub)type
     */
    BigDecimal getDecimalField(String fieldName);

    /**
     * Return the Integer value of the field with given name
     *
     * @param fieldName field's name
     * @return the field's integer value, when it's empty null is returned (not
     * 0)
     *
     * @throws IllegalArgumentException if given field is not Integer type
     */
    Integer getIntegerField(final String fieldName);

    /**
     * Return the Long value of the field with given name
     *
     * @param fieldName field's name
     * @return the field's long value, when it's empty null is returned (not 0)
     *
     * @throws IllegalArgumentException if given field is not Integer type
     */
    Long getLongField(final String fieldName);

    /**
     * Return the Date value of the field with given name
     *
     * @param fieldName field's name
     * @return the field's date value, when it's empty null is returned (not 0)
     *
     * @throws IllegalArgumentException
     */
    Date getDateField(final String fieldName);

    /**
     * Return the value, casted to entity, of the field with given name.
     *
     * @param fieldName field's name
     * @return the field's value
     *
     * @throws IllegalArgumentException if given field is not belongsTo type
     */
    Entity getBelongsToField(String fieldName);

    /**
     * Return the value, casted to list of entities, of the field with given
     * name.
     *
     * @param fieldName field's name
     * @return the field's value
     *
     * @throws IllegalArgumentException if given field have incompatible type
     */
    EntityList getHasManyField(String fieldName);

    /**
     * Return the value, casted to list of entities, of the field with given
     * name.
     *
     * @param fieldName field's name
     * @return the field's value
     */
    List<Entity> getManyToManyField(String fieldName);

    /**
     * Return the value, casted to tree, of the field with given name.
     *
     * @param fieldName field's name
     * @return the field's value
     */
    EntityTree getTreeField(String fieldName);

    /**
     * Set the value of the field with given name.
     *
     * @param fieldName field's name
     * @param fieldValue field'value
     */
    void setField(String fieldName, Object fieldValue);

    /**
     * Return all field's values.
     *
     * @return field's values - name - value pairs
     */
    Map<String, Object> getFields();

    /**
     * Return true if there is no global and field's errors.
     *
     * @return true if entity is valid
     */
    boolean isValid();

    /**
     * Set validation status as not valid
     */
    void setNotValid();

    /**
     * Return true if there is no field's errors for given field.
     *
     * @param fieldName field's name
     * @return true if field is valid
     */
    boolean isFieldValid(String fieldName);

    /**
     * Create new entity and copy fields values.
     *
     * Notice: This method copies all the fields of entity, including the ID and
     * fields with copyable attribute set to false. Returned copy is not
     * persisted. If you want to make persistent copy with unique ID and
     * copyable/persistent/etc. attributes aware consider use
     * {@link DataDefinition#copy(Long...)}
     *
     * @return copied entity
     */
    Entity copy();

    /**
     * Set if entity is active.
     *
     * @param active is active
     * @since 0.4.2
     */
    void setActive(boolean active);

    /**
     * Returns true if entity is active.
     *
     * @return true if active
     * @since 0.4.2
     */
    boolean isActive();
}
