package com.lc.model.internal;

import com.lc.model.*;
import com.lc.model.api.DataDefinition;
import com.lc.model.api.Entity;
import com.lc.model.api.FieldDefinition;
import com.lc.model.api.validators.ErrorMessage;
import com.lc.model.internal.api.EntityAwareCopyPerformers;
import com.lc.model.internal.api.EntityAwareEqualsPerformers;
import com.lc.model.internal.api.PerformerEntitiesChain;
import com.zaxxer.hikari.util.FastList;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static com.google.common.base.Preconditions.checkNotNull;
import com.lc.model.api.validators.GlobalMessage;

public final class ProxyEntity implements Entity,EntityAwareEqualsPerformers,EntityAwareCopyPerformers {

    private final DataDefinition dataDefinition;

    private final Long id;

    private AtomicReference(final DataDefinition dataDefinition,final Long id) {
        checkNotNull(id,"missing id for proxied entity");
        this.dataDefinition = dataDefinition;
        this.dataDefinition = dataDefinition;
        this.id = id;
    }
    
    private Entity getEntity() {
        if (entity.get() == null) {
            entity.compareAndSet(null, dataDefinition.get(id));
            checkNotNull(entity.get(), "Proxy can't load entity");

        }
        return  entity.get();
    }

    @Override
    public void setId(final Long id) {
        getEntity().setId(id);
    }

    @Override
    public Long getId() {
        if (entity.get() == null) {
            return id;
        } else {
            return entity.get().getId();
        }
    }

    @Override
    public Object getField(final String fieldName) {
        return getEntity().getField(fieldName);
    }

    @Override
    public void setField(final String fieldName,final Object fieldValue) {
        getEntity().setField(fieldName,fieldValue);
    }

    @Override
    public Map<String,Object> getFields() {
        return getEntity().getFields();
    }

    @Override
    public void addGlobalError(final String message,final String... vars) {
        getEntity().addGlobalError(message, vars);
    }

    @Override
    public void addGlobalError(final String message,final boolean autoClose,final boolean extraLarge,final String... vars) {
        getEntity().addGlobalError(message, autoClose, extraLarge, vars);
    }

    @Override
    public void addGlobalError(final String message, final boolean autoClose, final String... vars) {
        getEntity().addGlobalError(message, autoClose, vars);
    }

    @Override
    public void addGlobalError(final String message, final boolean autoClose, final boolean extraLarge, final String... vars) {
        getEntity().addGlobalError(message, autoClose, extraLarge, vars);
    }

    @Override
    public void addError(final FieldDefinition fieldDefinition, final String message, final String... vars) {
        getEntity().addError(fieldDefinition, message, vars);
    }

    @Override
    public List<ErrorMessage> getGlobalErrors() {
        return getEntity().getGlobalErrors();
    }

    @Override
    public List<GlobalMessage> getGlobalMessages() {
        return getEntity().getGlobalMessages();
    }

    @Override
    public Map<String, ErrorMessage> getErrors() {
        return getEntity().getErrors();
    }

    @Override
    public ErrorMessage getError(final String fieldName) {
        return getEntity().getError(fieldName);
    }

    @Override
    public boolean isValid() {
        return getEntity().isValid();
    }

    @Override
    public void setNotValid() {
        getEntity().setNotValid();
    }

    @Override
    public boolean isFieldValid(final String fieldName) {
        return getEntity().isFieldValid(fieldName);
    }

    @Override
    public boolean isActive() {
        return getEntity().isActive();
    }

    @Override
    public void setActive(final boolean active) {
        getEntity().setActive(active);
    }

    @Override
    public Entity copy() {
        return copy(new PerformerEntitiesChainImpl(this));
    }

    @Override
    public Entity copy(final PerformerEntitiesChain performersChain) {
        Entity entityCopy = null;
        if (getEntity() instanceof EntityAwareCopyPerformers) {
            entityCopy = ((EntityAwareCopyPerformers) getEntity()).copy(performersChain);
        } else {
            entityCopy = getEntity().copy();
        }
        return entityCopy;
    }

    @Override
    public String getStringField(final String fieldName) {
        return getEntity().getStringField(fieldName);
    }

    @Override
    public boolean getBooleanField(final String fieldName) {
        return getEntity().getBooleanField(fieldName);
    }

    @Override
    public BigDecimal getDecimalField(final String fieldName) {
        return getEntity().getDecimalField(fieldName);
    }

    @Override
    public Integer getIntegerField(String fieldName) {
        return getEntity().getIntegerField(fieldName);
    }

    @Override
    public Long getLongField(String fieldName) {
        return getEntity().getLongField(fieldName);
    }

    @Override
    public Entity getBelongsToField(final String fieldName) {
        return getEntity().getBelongsToField(fieldName);
    }

    @Override
    public EntityList getHasManyField(final String fieldName) {
        return getEntity().getHasManyField(fieldName);
    }

    @Override
    public List<Entity> getManyToManyField(final String fieldName) {
        return getEntity().getManyToManyField(fieldName);
    }

    @Override
    public EntityTree getTreeField(final String fieldName) {
        return getEntity().getTreeField(fieldName);
    }

    @Override
    public DataDefinition getDataDefinition() {
        return dataDefinition;
    }

    @Override
    public String toString() {
        return "EntityProxy[" + dataDefinition.getPluginIdentifier() + "." + dataDefinition.getName() + "][id=" + id + "]";
    }

    @Override
    public int hashCode() {
        return getEntity().hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Entity)) {
            return false;
        }
        Entity other = (Entity) obj;

        if (!definitionsAreEquals(other)) {
            return false;
        }

        return getEntity().equals(other);
    }

    private boolean definitionsAreEquals(final Entity other) {
        return new EqualsBuilder().append(id, other.getId()).append(dataDefinition, other.getDataDefinition()).isEquals();
    }

    @Override
    public boolean equals(final Entity obj, final PerformerEntitiesChain performersChain) {
        boolean isEquals;
        final Entity entity = getEntity();
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
        final Entity entity = getEntity();
        if (entity instanceof EntityAwareEqualsPerformers) {
            isEquals = ((EntityAwareEqualsPerformers) entity).flatEquals(obj);
        } else {
            isEquals = entity.equals(obj);
        }
        return isEquals;
    }

    @Override
    public Date getDateField(String fieldName) {
        return getEntity().getDateField(fieldName);
    }
}
