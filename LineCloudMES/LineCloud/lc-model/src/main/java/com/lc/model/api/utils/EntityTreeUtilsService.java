package com.lc.model.api.utils;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.lc.model.api.Entity;
import com.lc.model.api.EntityTree;
import com.lc.model.api.EntityTreeNode;
import com.lc.model.internal.DetachedEntityTreeImpl;
import com.lc.model.internal.api.PriorityService;

/**
 * Helper service for EntityTree
 */
@Service
public class EntityTreeUtilsService {

    @Autowired
    private PriorityService priorityService;

    /**
     * Return new instance of DetachedEntityTreeImpl, contains specified entities
     *
     * @param entities
     *            entity tree nodes
     * @return new instance of DetachedEntityTreeImpl
     */
    public static EntityTree getDetachedEntityTree(final List<Entity> entities) {
        return new DetachedEntityTreeImpl(entities);
    }

    /**
     * Return list of entities sorted in the same order as they appear on the tree
     *
     * @param tree
     *            entity tree containing entities to be listed
     * @return list of sorted entities
     *
     * @since 1.1.5
     */
    public List<Entity> getSortedEntities(final EntityTree tree) {
        List<Entity> nodesList = Lists.newLinkedList();
        if (tree.isEmpty()) {
            return nodesList;
        }
        return  getSortedEntitiesFromNode(tree.getRoot());
    }

    private List<Entity> getSortedEntitiesFromNode(final EntityTreeNode node) {
        List<Entity> nodesList = Lists.newLinkedList();
        nodesList.add(node);

        List<EntityTreeNode> childNodes = Lists.newLinkedList(node.getChildren());
        Collections.sort(childNodes,priorityService.getEntityPriorityComparator());
        for (EntityTreeNode childNode : childNodes) {
            nodesList.addAll(getSortedEntitiesFromNode(childNode));
        }

        return nodesList;
    }

}
