package com.lc.model.internal.hooks;

import java.lang.reflect.InvocationTargetException;

import com.lc.model.internal.AbstractModelXmlConverter;
import org.springframework.context.ApplicationContext;

import com.lc.model.api.DataDefinition;
import com.lc.model.api.FieldDefinition;


public abstract class AbstractModelHookDefinition extends  AbstractHookDefinition {

    private DataDefinition dataDefinition;

    private FieldDefinition fieldDefinition;

    public AbstractModelXmlConverter(final String className,final String methodName,final String pluginIdentifier,
           final  ApplicationContext applicationContext ) throws HookInitializationException {
        super(className,methodName,pluginIdentifier,applicationContext);
    }

    public final void initialize(final DataDefinition dataDefinition) {
        this.dataDefinition =dataDefinition;
    }

    public final void initialize(final DataDefinition dataDefinition,final FieldDefinition fieldDefinition ) {
        this.dataDefinition =dataDefinition;
        this.fieldDefinition = fieldDefinition;

    }

    protected final boolean call(final Object... args) {
        try {
            Object resule =getMethod().invoke(getBean(), args);

            if (resule instanceof Boolean) {
                return (Boolean) resule;
            } else {
                return true;
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("Failed to invoke hook method",e);

        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Failed to invoke hook method", e);
        } catch (InvocationTargetException e) {
            throw new IllegalStateException("Failed to invoke hook method", e);
        }

    }

    public DataDefinition getDataDefinition() {
        return dataDefinition;
    }

    public FieldDefinition getFieldDefinition() {
        return fieldDefinition;
    }
}
