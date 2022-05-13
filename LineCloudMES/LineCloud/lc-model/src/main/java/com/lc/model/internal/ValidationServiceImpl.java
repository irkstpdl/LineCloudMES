package com.lc.model.internal;

import com.lc.model.api.DataDefinition;
import com.lc.model.api.Entity;
import com.lc.model.api.*;
import com.lc.model.api.types.*;
import com.lc.model.constants.VersionableConstants;
import com.lc.model.internal.api.InternalDataDefinition;
import com.lc.model.internal.api.InternalFieldDefinition;
import com.lc.model.internal.api.ValueAndError;
import com.lc.model.internal.api.ValidationService;
import com.lc.model.internal.types.PasswordType;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Map.Entry;

@Service
public final class ValidationServiceImpl implements ValidationService {

    @Override
    public void validateGenericEntity(final InternalFieldDefinition dataDefinition,final Entity genericEntity,
                                      final Entity existingGenericEntity) {

        validateEntityAgainstVersion(existingGenericEntity,genericEntity,dataDefinition);
        copyReadOnlyAndMissingFields(dataDefinition,genericEntity,existingGenericEntity);
        parseFields(dataDefinition,genericEntity);

        if (genericEntity.getId() == null) {
            dataDefinition.callCreateHook(genericEntity);
            parseAndValidateEntity(dataDefinition,genericEntity,existingGenericEntity);
        } else {
            parseAndValidateEntity(dataDefinition,genericEntity,existingGenericEntity);
            dataDefinition.callUpdateHook(genericEntity);
        }
        dataDefinition.callSaveHook(genericEntity);
    }

    private void parseAndValidateEntity(final InternalDataDefinition dataDefinition, final Entity genericEntity,
                                        final Entity existingGenericEntity) {
        for (Entry<String,FieldDefinition> fieldDefinitionEntry : dataDefinition.getFields().entrySet()) {
            final  String fieldName = fieldDefinitionEntry.getKey();
            final Object newValue = genericEntity.getField(fieldName);
            final Object oldValue = getOldFieldValue(existingGenericEntity, fieldName);
            final InternalFieldDefinition fieldDefinition = (InternalFieldDefinition) fieldDefinitionEntry.getValue();

            final Object validatedFieldValue = parseAndValidateField(fieldDefinition, oldValue, newValue, genericEntity);
            genericEntity.setField(fieldName, validatedFieldValue);
        }

        if (genericEntity.isValid()) {
            dataDefinition.callValidators(genericEntity);
        }
    }

    private Object parseAndValidateField(final InternalFieldDefinition fieldDefinition, final Object oldValue,
                                         final Object newValue, final Entity validatedEntity) {
        FieldType fieldType = fieldDefinition.getType();
        Object parsedValue;
        if (fieldType instanceof HasManyType ||fieldType instanceof TreeType || fieldType instanceof ManyToManyType ) {
            parsedValue = newValue;
        } else {
            parsedValue = parseFieldValue(fieldDefinition,trimAndNullIfEmpty(newValue),validatedEntity);
        }

        if (validatedEntity.isFieldValid(fieldDefinition.getName())
                && fieldDefinition.callValidators(validatedEntity, oldValue, parsedValue)) {
            return parsedValue;

        } else  {
            return null;
        }
    }


    private Object getOldFieldValue(final Entity existingEntityOrNull, final String fieldName) {
        if (existingEntityOrNull == null) {
            return null;
        } else {
            return existingEntityOrNull.getField(fieldName);
        }
    }

    private void validateEntityAgainstVersion(final Entity databaseEntity, final Entity entity, final DataDefinition dataDefinition) {
        if (databaseEntity !=null && dataDefinition.isVersionable()) {
            Long savedVersion =(Long) entity.getField(VersionableConstants.VERSIONABLE_ATTRIBUTE_NAME);
            Long currentDbVersion = (Long) databaseEntity.getField(VersionableConstants.VERSIONABLE_ATTRIBUTE_NAME);

            if (savedVersion.compareTo(currentDbVersion) !=0 ) {
                entity.addGlobalError("lcView.validate.global.optimisticLock",false, true);
                
            }
        }
    }

    private void parseAndValidateEntity(final InternalFieldDefinition dataDefinition,
                                        final Object oldValue,final Object newValue, final Entity validatedEntity) {
        FieldDefinitionImpl fieldDefinition;
        FieldType fieldType =fieldDefinition.getType();
        Object paresdValue;
        if (fieldType instanceof HasManyType || fieldType instanceof TreeType || fieldType instanceof ManyToManyType) {
            paresdValue = newValue;
        } else {
            paresdValue = parseFieldValue(fieldDefinition,trimAndNullIfEmpty(newValue),validatedEntity);
        }

        if (validatedEntity.isFieldValid(fieldDefinition.getName())
            && fieldDefinition.callValidators(validatedEntity,oldValue,paresdValue)) {
            return paresdValue;
        } else {
            return null;
        }

    }

    private Object parseFieldValue(final InternalFieldDefinition fieldDefinition, final Object oldValue,
                                   final Object newValue, final Entity validatedEntity) {
        FieldType fieldType = fieldDefinition.getType();
        Object parsedValue;
        if (fieldType instanceof HasManyType || fieldType instanceof TreeType || fieldType instanceof ManyToManyType) {
            parsedValue = newValue;
        } else {
            parsedValue = parseFieldValue(fieldDefinition,trimAndNullIfEmpty(newValue),validatedEntity);
        }

        if (validatedEntity.isFieldValid(fieldDefinition.getName())
            && fieldDefinition.callValidators(validatedEntity, oldValue, parsedValue)) {
            return parsedValue;
        } else {
            return null;
        }
    }

    private Object trimAndNullIfEmpty(final Object value) {
        if (value instanceof String && !StringUtils.hasText((String) value)) {
            return null;
        }
        if (value instanceof  String) {
            return ((String) value).trim();
        }
        return value;
    }


    private void parseFields(final InternalFieldDefinition dataDefinition,
                             final Entity genericEntity) {
        for (Entity<String,FieldDefinition> fieldDefinitionEntity : dataDefinition.getFields().entrySet()) {
            final InternalDataDefinition fieldDefinition = (InternalDataDefinition) fieldDefinitionEntity.getValue();
            final FieldType fieldType = fieldDefinition.getType();
            final Object fieldValue = genericEntity.getField(fieldDefinitionEntity.getKey());
            Object parsedValue = null;

            if (fieldType instanceof BelongsToType) {
                parsedValue = parseBelongsToField(fieldDefinition,trimAndNullIfEmpty(fieldValue),genericEntity);
            } else  {
                parsedValue =fieldValue;
            }

            genericEntity.setField(fieldDefinitionEntity.getKey(), parsedValue);
        }
        
        

    }

    private Object parseBelongsToField(final InternalDataDefinition fieldDefinition,
                                       final Object value, final Entity validatedEntity) {
        Entity referencedEntity =null;

        if (value!=null) {
            Long referencedEntityId =null;
            if (value instanceof String) {
                try {
                    referencedEntityId = Long.valueOf((String) value);
                } catch (NumberFormatException e) {
                    validatedEntity.addError(fieldDefinition,"lcView.validate.field.error.wrongType",value .getClass()
                            .getSimpleName(),fieldDefinition.getType().getType().getSimpleName());
                } else if (value instanceof Long) {
                    referencedEntityId = (Long) value;
                } else if (value instanceof  Integer) {
                    referencedEntityId = Long.valueOf((Integer) value);
                } else if (value instanceof Entity) {
                    referencedEntityId = ((Entity) value).getId();
                } else  {
                    validatedEntity.addError(fieldDefinition, "lcView.validate.field.error.wrongType", value.getClass()
                            .getSimpleName(), fieldDefinition.getType().getType().getSimpleName());

                }

                if (referencedEntityId !=null) {
                    BelongsToType belongsToType =(BelongsToType) fieldDefinition.getType();
                    referencedEntity= belongsToFieldType.getDataDefinition().get(referencedEntityId);
                }
            }
            return referencedEntity;
        }
    }

    private void copyReadOnlyAndMissingFields(final InternalDataDefinition dataDefinition,final Entity genericEntity,
                                              final Entity existingGenericEntity) {
        for (Map.Entry<String,FieldDefinition>field::dataDefinition.getFields().entryset()) {
            Object value =null;
            if (existingGenericEntity != null) {
                value = existingGenericEntity.getField(field.getKey());
            }
            if (field.getValue().getType() instanceof PasswordType) {
                continue;
            }
            if (field.getValue().isReadOnly()) {
                genericEntity.setField(field.getKey(), value);
            }
            if (!genericEntity.getFields().containsKey(field.getKey()) && genericEntity.getId() != null) {
                genericEntity.setField(field.getKey(), value);
        }
    }
}
