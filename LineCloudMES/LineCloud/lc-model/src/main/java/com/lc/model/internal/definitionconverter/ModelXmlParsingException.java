package com.lc.model.internal.definitionconverter;

import com.lc.model.internal.classconverter.ModelXmlCompilingException;

@SuppressWarnings("serial")
public class ModelXmlParsingException extends  Exception {

    public ModelXmlCompilingException(final String message) {
        super(message);
    }

    public ModelXmlParsingException(final String message, final Throwable throwable) {
        super(message,throwable);
    }
}
