package com.lc.model.api.search;

// import org.hibernate.criterion.CriteriaSpecification;

/**
 * Supported join types
 *
 * @author PhiliphG
 * @since 1.2.1
 */
public enum JoinType {
    /**
     * Specifies joining to an entity based on a full join.
     */
    FULL(CriteriaSpecification.FULL_JOIN),
}
