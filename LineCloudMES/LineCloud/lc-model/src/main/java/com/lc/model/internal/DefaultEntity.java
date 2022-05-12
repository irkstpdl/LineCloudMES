package com.lc.model.internal;

import com.google.common.collect.Lists;
// import com.qcadoo.localization.api.utils.DateUtils;
import com.lc.model.api.*;
import com.lc.model.api.types.BelongsToType;
import com.lc.model.api.validators.ErrorMessage;
import com.lc.model.internal.api.EntityAwareCopyPerformers;
import com.lc.model.internal.api.EntityAwareEqualsPerformers;
import com.lc.model.internal.api.PerformerEntitiesChain;
import com.lc.model.internal.api.ValueAndError;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;
import java.util.*;

import static com.google.common.base.Preconditions.checkArgument;
import com.lc.model.api.validators.GlobalMessage;
public final class DefaultEntity implements Entity,EntityAwareEqualsPerformers,EntityAwareEqualsPerformers {

    private Long id;

    private final DataDefinition dataDefinition;

    private final Map<String,Object> fields;

    private final EntityMessagesHolder messagesHolder = new EntityMessagesHolderImpl();

    private boolean notValidFlag = false;

    private boolean active = true;

    public DefaultEntity(final DataDefinition dataDefinition,final Long id, final Map<String,Object> fields) {
        this.dataDefinition=dataDefinition;
        this.id = id;
        this.fields =fields;
    }

    public DefaultEntity(final DataDefinition dataDefinition,final Long id) {
        this(dataDefinition, id,new HashMap<>());
    }

    public DefaultEntity(final DefaultEntity defaultEntity) {
        this(defaultEntity,id,new HashMap<>());
    }

    @Override
    public void setId(final Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setActive(final boolean active) {
        this.active = active;
    }

    @Override
    public void setFields(final String fieldName,final Object fieldValue) {
        fields.put(fieldName,fieldValue);
    }

    @Override
    public Map<String ,Object> getFields() {
        return fields;
    }

    @Override
    public void addGlobalError(final String message,final String... vars) {
        messagesHolder.addGlobalError(message, vars);
    }

    @Override
    public void addGlobalMessage(final String message,final String... vars) {
        messagesHolder.addGlobalMessage(message, vars);
    }

    @Override
    public void addGlobalMessage(String message, boolean autoClose, final boolean extraLarge, String... vars) {
        messagesHolder.addGlobalMessage(message, autoClose, extraLarge, vars);
    }

    @Override
    public void addGlobalError(String message, boolean autoClose, String... vars) {
        messagesHolder.addGlobalError(message, autoClose, vars);
    }

    @Override
    public void addGlobalError(String message, boolean autoClose, final boolean extraLarge, String... vars) {
        messagesHolder.addGlobalError(message, autoClose, extraLarge, vars);
    }

    @Override
    public void addError(final FieldDefinition fieldDefinition, final String message, final String... vars) {
        messagesHolder.addError(fieldDefinition, message, vars);
    }

    @Override
    public List<ErrorMessage> getGlobalErrors() {
        return messagesHolder.getGlobalErrors();
    }

    @Override
    public List<GlobalMessage> getGlobalMessages() {
        return messagesHolder.getGlobalMessages();
    }

    @Override
    public Map<String, ErrorMessage> getErrors() {
        return messagesHolder.getErrors();
    }

    @Override
    public ErrorMessage getError(final String fieldName) {
        return messagesHolder.getError(fieldName);
    }

    @Override
    public boolean isValid() {
        return !notValidFlag && getErrors().isEmpty() && getGlobalErrors().isEmpty();
    }

    @Override
    public boolean isFieldValid(final String fieldName) {
        return messagesHolder.getError(fieldName) == null;
    }

    @Override
    public void setNotValid() {
        notValidFlag = true;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder(23,41).append(id).append(dataDefinition);

        for (Map.Entry<String,Object> field : fields.entrySet()) {
            if (field.getValue() instanceof Collection ) {
                continue;
            }
            if (field.getValue() instanceof Entity) {
                Entity entity = (Entity) field.getValue();
                hcb..append(field.getKey()).append(entity.getDataDefinition().getPluginIdentifier())
                        .append(entity.getDataDefinition().getName()).append(entity.getId());

            } else {
                hcb.append(field.getKey()).append(field.getValue());
            }
        }

        return hcb.toHashCode();
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
        return equals(other,new PerformerEntitiesChainImpl(this));
    }

    @Override
    public boolean flatEquals(final Entity otherEntity) {
        return otherEntity != null && definitionsAndIdsAreEqual(otherEntity) && fieldsAreEquals(otherEntity,null,true);

    }
}
