package com.lc.model.api.units;

import java.util.Comparator;

import com.lc.model.api.DataDefinition;
import com.lc.model.api.Entity;
import com.lc.model.api.EntityTree;
import com.lc.model.api.EntityTreeNode;

/**
 * Helper service for automatically generating numbers for EntityTree nodes
 *
 * @since 0.4.8
 */

public interface TreeNumberingService {

    /**
     * Generate new numbers for all nodes of the tree
     *
     * @param tree
     *            tree to be numbered
     */

    void  generateTreeNumbers(final EntityTree tree);

    /**
     * Generate new numbers for all sub-nodes of given tree node
     *
     * @param treeNode
     *            tree node to be numbered (with sub-nodes)
     */
    void  generateTreeNumbers(final EntityTreeNode treeNode);

    /**
     * Generate new numbers for all nodes of the tree and save them
     *
     * @param tree
     *            tree entity
     */
    void generateNumbersAndUpdateTree(final EntityTree tree);

    /**
     * Generate new numbers for all nodes of the tree and save them
     *
     * @param dd
     *            node component DataDefinition
     * @param joinFieldName
     *            name of tree field
     * @param belongsToEntityId
     *            id of owning tree entity
     */

    void generateNumbersAndUpdateTree(final DataDefinition dd, final String joinFieldName, final Long belongsToEntityId);

    /**
     * Getter for tree node numbers comparator
     *
     * @return instance of TreeNodesNumberComparator
     */

    Comparator<Entity> getTreeNodesNumberComparator();

}
