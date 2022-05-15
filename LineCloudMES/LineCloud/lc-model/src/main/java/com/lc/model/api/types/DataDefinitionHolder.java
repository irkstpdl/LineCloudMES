package com.lc.model.api.types;

import com.lc.model.api.DataDefinition;

/**
 * Interface for fields that can return DataDefinition of corresponding model.
 *
 * @since 0.1.10
 */
public interface DataDefinitionHolder  extends FieldType {

    /**
     * Returns data definition of corresponding model.
     *
     * @return data definition of corresponding model.
     */
    DataDefinition getDataDefinition();

}
