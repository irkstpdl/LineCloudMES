package com.lc.model.api.types;

/**
 * Object represents "belongs to" field type.
 *
 * @since 0.4.0
 */
public interface BelongsToType extends FieldType, DataDefinitionHolder {

    /**
     * Returns true if field will be lazy loaded.
     *
     * @return true if lazy loading
     */
    boolean isLazyLoading();

}
