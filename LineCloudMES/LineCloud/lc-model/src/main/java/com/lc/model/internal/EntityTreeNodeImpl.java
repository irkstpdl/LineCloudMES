package com.lc.model.internal;

import com.lc.model.api.*;
import com.lc.model.api.validators.ErrorMessage;
import com.lc.model.api.validators.GlobalMessage;
import com.lc.model.internal.api.EntityAwareCopyPerformers;
import com.lc.model.internal.api.EntityAwareEqualsPerformers;
import com.lc.model.internal.api.PerformerEntitiesChain;

import com.lc.model.api.Entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class EntityTreeNodeImpl implements EntityTreeNode,EntityAwareCopyPerformers,EntityAwareEqualsPerformers{

    private final List<EntityTreeNode> children = new ArrayList<>();

    private final Entity entity;

    public EntityTreeNodeImpl(final Entity entity) {
        this.entity = entity;
    }

    @Override
    public List<EntityTreeNode> getChildren() {
        return children;
    }

    @Override
    public String getEntityNoteType() {
        return getStringField("entityType");
    }

    public void addChild(final EntityTreeNode entityTreeNode) {
        children.add(entityTreeNode);
    }

    @Override
    public void setId(final Long id) {
        entity.setId(id);
    }

    @Override
    public Long getId() {
        return entity.getId();
    }

    @Override
    public DataDefinition getDataDefinition() {
        return entity.getDataDefinition();
    }

    @Override
    public Object getField(final String fieldName) {
        return entity.getField(fieldName);
    }

    @Override
    public String getStringField(final String fieldName) {
        return entity.getStringField(fieldName);
    }

    @Override
    public boolean getBooleanField(final String fieldName) {
        return entity.getBooleanField(fieldName);
    }

    @Override
    public BigDecimal getDecimalField(final String fieldName) {
        return entity.getDecimalField(fieldName);
    }

    @Override
    public Integer getIntegerField(final String fieldName) {
        return entity.getIntegerField(fieldName);
    }

    @Override
    public Long getLongField(final String fieldName) {
        return entity.getLongField(fieldName);
    }

    @Override
    public Entity getBelongsToField(final String fieldName) {
        return entity.getBelongsToField(fieldName);
    }

    @Override
    public EntityList getHasManyField(final String fieldName) {
        return entity.getHasManyField(fieldName);
    }

    @Override
    public List<Entity> getManyToManyField(final String fieldName) {
        return entity.getManyToManyField(fieldName);
    }

    @Override
    public EntityTree getTreeField(final String fieldName) {
        return entity.getTreeField(fieldName);
    }

    @Override
    public void setField(final String fieldName, final Object fieldValue) {
        entity.setField(fieldName, fieldValue);
    }
    @Override
    public Map<String, Object> getFields() {
        return entity.getFields();
    }

    @Override
    public void addGlobalError(final String message, final String... vars) {
        entity.addGlobalError(message, vars);
    }

    @Override
    public void addGlobalMessage(final String message, final String... vars) {
        entity.addGlobalMessage(message, vars);
    }

    @Override
    public void addGlobalMessage(final String message, final boolean autoClose, final boolean extraLarge, final String... vars) {
        entity.addGlobalMessage(message, autoClose, extraLarge, vars);
    }

    @Override
    public void addGlobalError(final String message, final boolean autoClose, final String... vars) {
        entity.addGlobalError(message, autoClose, vars);
    }

    @Override
    public void addGlobalError(final String message, final boolean autoClose, final boolean extraLarge, final String... vars) {
        entity.addGlobalError(message, autoClose, extraLarge, vars);
    }

    @Override
    public void addError(final FieldDefinition fieldDefinition, final String message, final String... vars) {
        entity.addError(fieldDefinition, message, vars);
    }

    @Override
    public List<ErrorMessage> getGlobalErrors() {
        return entity.getGlobalErrors();
    }

    @Override
    public List<GlobalMessage> getGlobalMessages() {
        return entity.getGlobalMessages();
    }

    @Override
    public Map<String, ErrorMessage> getErrors() {
        return entity.getErrors();
    }

    @Override
    public ErrorMessage getError(final String fieldName) {
        return entity.getError(fieldName);
    }

    @Override
    public boolean isValid() {
        return entity.isValid();
    }

    @Override
    public void setNotValid() {
        entity.setNotValid();
    }

    @Override
    public boolean isFieldValid(final String fieldName) {
        return entity.isFieldValid(fieldName);
    }

    @Override
    public String toString() {
        return entity.toString();
    }

    @Override
    public boolean isActive() {
        return entity.isActive();
    }

    @Override
    public void setActive(final boolean active) {
        entity.setActive(active);
    }

    @Override
    public EntityTreeNodeImpl copy() {
        return copy(new PerformerEntitiesChainImpl(this));
    }

    @Override
    public EntityTreeNodeImpl copy(final PerformerEntitiesChain performersChain) {
        Entity entityCopy = null;
        if (entity instanceof EntityAwareCopyPerformers) {
            entityCopy = ((EntityAwareCopyPerformers) entity).copy(performersChain);
        } else {
            entityCopy = entity.copy();
        }
        return new EntityTreeNodeImpl(entityCopy);
    }

    @Override
    public int hashCode() {
        return entity.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        return entity.equals(obj);
    }

    @Override
    public boolean equals(final Entity obj, final PerformerEntitiesChain performersChain) {
        boolean isEquals;
        if (entity instanceof EntityAwareEqualsPerformers) {
            isEquals = ((EntityAwareEqualsPerformers) entity).equals(obj, performersChain);
        } else {
            isEquals = entity.equals(obj);
        }
        return isEquals;
    }

    @Override
    public boolean flatEquals(final Entity obj) {
        boolean isEquals;
        if (entity instanceof EntityAwareEqualsPerformers) {
            isEquals = ((EntityAwareEqualsPerformers) entity).flatEquals(obj);
        } else {
            isEquals = entity.equals(obj);
        }
        return isEquals;
    }

    @Override
    public Date getDateField(String fieldName) {
        return entity.getDateField(fieldName);
    }

