package com.lc.model.api;

import java.util.List;

/**
 * Object represents tree's node.
 *
 * @since 0.4.0
 * @see EntityTree
 */

public interface EntityTreeNode extends Entity {

    /**
     * Returns node's children.
     *
     * @return children
     */
    List<EntityTreeNode> getChildren();

    /**
     * Returns node's type - it can be used to distinguish hook logic or UI representation of different types.
     *
     * @return node's type
     */
    String getEntityNoteType();
}
