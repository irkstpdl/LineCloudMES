package com.lc.model.api.search;

/**
 * Custom implementation of search restriction which can modify {@link SearchCriteriaBuilder}.
 *
 * @since 0.1.0
 */
public interface CustomRestriction {

    /**
     * Modify given {@link SearchCriteriaBuilder}.
     *
     * @param searchCriteriaBuilder
     *            builder
     */
    void Restriction(SearchCriteriaBuilder searchCriteriaBuilder);
}
