package com.lc.model.internal;

import com.lc.model.api.DataDefinition;
import com.lc.model.api.Entity;
import com.lc.model.api.FieldDefinition;
import com.lc.model.api.types.FieldType;
import com.lc.model.internal.api.DefaultValidatorsProvider;
import com.lc.model.internal.api.FieldHookDefinition;
import com.lc.model.internal.api.InternalDataDefinition;
import com.lc.model.internal.api.InternalFieldDefinition;
import com.lc.model.internal.types.TextType;
import com.lc.model.internal.types.StringType;
import com.lc.model.internal.validators.RequiredValidator;
import com.lc.model.internal.validators.UniqueValidator;

//plugin.internal.PluginUtilsService


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public  final class FieldDefinitionImpl implements InternalFieldDefinition {

    private final String name;

    private FieldType type;

    private final List<FieldHookDefinition> valiadtors = new ArrayList<>();

    private boolean readOnly;

    private boolean required;

    private boolean unique;

    private boolean persistent =true;

    private Object defaultValue;

    private final DataDefinition dataDefinition;

    private String expression;

    private boolean enabled = true;

    private String pluginIdentifier;

    public FieldDefinitionImpl (final DataDefinition dataDefinition, final String name) {
        this.dataDefinition = dataDefinition;
        this.name = name;
    }

    @Override
    public  String getName() {
        return name;
    }

    @Override
    public String getValue(final Object value, final  Locale locale) {
        if (value == null) {
            return null;

        }else {
            return type.toString(value,locale);
        }
    }

    @Override
    public FieldType getType() {
        return type;
    }

    public FieldDefinitionImpl withType (final type) {
        this.type = type;
        return this;
    }

    public List<FieldHookDefinition> getValiadtors() {
        return valiadtors;
    }

    @Override
    public DataDefinition getDataDefinition() {
        return dataDefinition;
    }

    public FieldDefinitionImpl withValidator(final FieldHookDefinition validator) {
        validator.initialize(dataDefinition, this);
        if (validator instanceof RequiredValidator) {
            required = true;
        }
        if (validator instanceof UniqueValidator) {
            unique = true;
        }
        this.valiadtors.add(validator);
        return this;
    }

    public FieldDefinitionImpl withMissingDefaultValidators() {
        if (type instanceof DefaultValidatorsProvider) {
            DefaultValidatorsProvider resolver = (DefaultValidatorsProvider) type;
            for (FieldDefinition missingValiadtor : resolver.getMissingValidators(getValiadtors())) {
                withValidator(missingValiadtor);
            }
        }
        return this;
    }

    public FieldDefinitionImpl withReadOnly(final boolean readOnly) {
        this.readOnly =readOnly;
        return this;
    }
    @Override
    public boolean isReadOnly() {
        return readOnly || expression != null;
    }

    @Override
    public boolean isRequired() {
        return required && expression == null;
    }

    @Override
    public Object getDefaultValue() {
        return defaultValue;
    }

    public FieldDefinition withDefaultValue(final Object defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    @Override
    public boolean isUnique() {
        return unique && expression == null;
    }

    public void setPersistent(final boolean persistent) {
        this.persistent = persistent;
    }

    @Override
    public boolean isPersistent() {
        return persistent && expression == null;
    }

    public void setExpression(final String expression) {
        this.expression = expression;
    }

    @Override
    public String getExpression() {
        return expression;
    }

    public String getPluginIdentifier() {
        return pluginIdentifier;
    }

    public void setPluginIdentifier(final String pluginIdentifier) {
        this.pluginIdentifier = pluginIdentifier;
    }

    @Override
    public boolean callValidators(final Entity entity, final Object oldValue, final Object newValue) {
        for (FieldHookDefinition hook : validators) {
            if (PluginUtilsService.isEnabled(pluginIdentifier) && !hook.call(entity, oldValue, newValue)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(13, 31).append(defaultValue).append(name).append(required).append(type).append(unique)
                .append(validators).append(readOnly).append(expression).toHashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FieldDefinitionImpl)) {
            return false;
        }
        FieldDefinitionImpl other = (FieldDefinitionImpl) obj;
        return new EqualsBuilder().append(defaultValue, other.defaultValue).append(name, other.name)
                .append(required, other.required).append(type, other.type).append(unique, other.unique)
                .append(validators, other.validators).append(readOnly, other.readOnly).append(expression, other.expression)
                .isEquals();
    }

    @Override
    public String toString() {
        return "FieldDefinition: " + name;
    }

    @Override
    public boolean isEnabled() {
        return enabled && ((InternalDataDefinition)dataDefinition).isEnabled();
    }

    @Override
    public void enable() {
        enabled = true;
    }

    @Override
    public void disable() {
        enabled = false;
    }

    @Override
    public boolean canBeBothCopyableAndUnique() {
        return type instanceof StringType || type instanceof TextType;
    }




}
