package com.lc.model.api;

import java.util.List;

import com.lc.model.api.search.SearchCriteriaBuilder;

/**
 * Object represents list of entities from tree relation.
 *
 * @since 0.4.0
 * @see Entity#getTreeField(String)
 */
public interface EntityTree extends List<Entity> {

    /**
     * Creates search criteria builder for this entities' data definition - it will be automatically restricted with tree
     * relation.
     *
     * @see DataDefinition#find()
     * @return new search criteria builder
     */
    SearchCriteriaBuilder find();

    /**
     * Returns root of the tree.
     *
     * @return root
     */
    EntityTreeNode getRoot();

}
