package com.lc.model.internal;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import com.lc.model.api.EntityMessagesHolder;
import com.lc.model.api.FieldDefinition;
import com.lc.model.api.validators.ErrorMessage;
import com.lc.model.api.validators.GlobalMessage;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class EntityMessagesHolderImpl implements EntityMessagesHolder {

    private final List<ErrorMessage> globalErrors;

    private final List<GlobalMessage> globalMessages;

    private final Map<String, ErrorMessage> fieldErrors;

    public EntityMessagesHolderImpl() {
        globalErrors = Lists.newArrayList();
        globalMessages = Lists.newArrayList();
        fieldErrors = Maps.newHashMap();
    }

    public EntityMessagesHolderImpl(final EntityMessagesHolderImpl messagesHolder) {
        globalErrors =Lists.newArrayList(messagesHolder.getGlobalErrors());
        globalErrors = Lists.newArrayList(messagesHolder.getGlobalMessages());
        fieldErrors = Maps.newHashMap(messagesHolder.getErrors());
    }

    @Override
    public void addGlobalError(final String message, final String... vars) {
        globalErrors.add(new ErrorMessage(message,vars));
    }

    @Override
    public void addGlobalMessage(final String message,final String... vars) {
        globalMessages.add(new GlobalMessage(message,vars));
    }

    @Override
    public void addGlobalMessage(final String message, final boolean autoClose, final boolean extraLarge, final String... vars) {
        globalMessages.add(new GlobalMessage(message, autoClose, extraLarge, vars));
    }

    @Override
    public void addGlobalError(final String message, final boolean autoClose, final String... vars) {
        globalErrors.add(new ErrorMessage(message, autoClose, vars));
    }

    @Override
    public void addGlobalError(final String message, final boolean autoClose, final boolean extraLarge, final String... vars) {
        globalErrors.add(new ErrorMessage(message, autoClose, extraLarge, vars));
    }

    @Override
    public void addError(final FieldDefinition fieldDefinition, final String message, final String... vars) {
        fieldErrors.put(fieldDefinition.getName(), new ErrorMessage(message, vars));
    }

    @Override
    public List<ErrorMessage> getGlobalErrors() {
        return Collections.unmodifiableList(globalErrors);
    }

    @Override
    public List<GlobalMessage> getGlobalMessages() {
        return Collections.unmodifiableList(globalMessages);
    }

    @Override
    public Map<String, ErrorMessage> getErrors() {
        return Collections.unmodifiableMap(fieldErrors);
    }

    @Override
    public ErrorMessage getError(final String fieldName) {
        return fieldErrors.get(fieldName);
    }





}
