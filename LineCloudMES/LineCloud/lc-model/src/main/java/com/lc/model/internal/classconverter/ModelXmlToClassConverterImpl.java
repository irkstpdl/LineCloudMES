package com.lc.model.internal.classconverter;

import com.lc.model.constants.VersionableConstants;
import com.lc.model.internal.AbstractModelXmlConverter;
import com.lc.model.internal.api.ModelXmlToClassConverter;
import com.lc.model.internal.utils.ClassNameUtils;

import javassist.*;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;

@Component
public final class ModelXmlToClassConverterImpl extends AbstractModelXmlConverter implements ModelXmlToClassConverter,
        BeanClassLoaderAware {

    private static final String L_FAILED_TO_COMPILE_CLASS = "Failed to compile class ";

    private static final String L_NAME = "name";

    private static final String L_ERROR_WHILE_PARSING_MODEL_XML = "Error while parsing model.xml: ";

    private static final Logger LOG = LoggerFactory.getLogger(ModelXmlToClassConverterImpl.class);

    private final ClassPool classPool = ClassPool.getDefault();

    private ClassLoader classLoader;

    public ModelXmlToClassConverterImpl () {
        super();
        classPool.appendClassPath(new ClassClassPath(org.))
    }
}
