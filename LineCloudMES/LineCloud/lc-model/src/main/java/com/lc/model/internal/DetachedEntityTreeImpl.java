package com.lc.model.internal;

import static com.google.common.base.Preconditions.checkState;

import com.google.common.base.Preconditions;
import com.lc.model.api.Entity;
import com.lc.model.api.EntityTree;
import com.lc.model.api.search.SearchCriteriaBuilder;
import java.util.AbstractList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class DetachedEntityTreeImpl extends AbstractList<Entity> implements EntityTree {

    private List<Entity>entities =null;

    private EntityTreeNodeImpl root = null;

    public DetachedEntityTreeImpl(List<Entity> entities) {
        super();

        Preconditions.checkArgument(entities != null,"given entity list should not be null!");
        this.entities =entities;
        checkEntities();
    }

    private void checkEntities() {
        Map<Long,EntityTreeNodeImpl>entitiesById = new LinkedHashMap<Long, EntityTreeNodeImpl>();
        for (Entity entity : entities) {
            entitiesById.put(entity.getId(), new EntityTreeNodeImpl(ebtity));
        }

        for (EntityTreeNodeImpl entity : entitiesById.values()) {
            Entity parent = entity.getBelongsToField("Parent");
            if (parent ==null) {
                checkState(root = null,"Tree cannot have multiple roots");
                root = entity;
            } else {
                checkState(entitiesById.get(parent.getId()) !=null,"Parent for tree node (\" + entity + \") not found");
                entitiesById.get(parent.getId()).addChild(entity);
            }
        }

        Preconditions.checkState(entities.isEmpty() || root !=null,"Root for tree not found");

    }

    @Override
    public SearchCriteriaBuilder find() {
        throw  new UnsupportedOperationException("Cannot find entity for detached entity tree");
    }

    @Override
    public Entity get(final int index) {
        return entities.get(index);
    }

    @Override
    public int size() {
        return  entities.size();
    }

    @Override
    public EntityTreeNodeImpl getRoot() {
        return root;
    }

    public boolean checkIfTreeContainsEntity(final Long entityId) {
        if (entityId ==null){
            return false;
        }
        for (Entity entity : entities) {
            if (entityId.equals(entity.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "EntityTree[DETACHED!][size=" + size() + "]";
    }


}
