package com.lc.model.api.types;

/**
 * Interface for fields that using joinField.
 *
 * @since 0.1.10
 */
public interface JoinFieldHolder extends FieldType {

    /**
     * Returns field name joining the relation.
     *
     * @return join field
     */
    String getJoinFieldName();
}
