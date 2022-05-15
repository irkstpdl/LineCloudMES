package com.lc.model.api.search;

import com.lc.model.api.types.CollectionFieldType;

/**
 * Object represents "many to many" field type.
 *
 * @since 0.1.9
 */
public interface SearchOrder extends CollectionFieldType {

    /**
     * Returns true if field will be lazy loaded.
     *
     * @return true if lazy loading
     */
    boolean isLazyLoading();
}
