package com.lc.model.internal.api;

import org.springframework.core.io.support.ResourcePatternResolver;

public final class Constants {

    private Constants(){

    }

    public static final String XSL = "com/lc/model/model.xsl";

    public static final String XSL_ORACLE_10G = "com/lc/model/model-ora10g.xsl";

    public static final String XSD = "com/lc/model/model.xsd";

    public static final String RESOURCE_PATTERN = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "model/*.xml";

    public static final String VALIDATION_MESSAGE_REQUIRED = "required";

    public static final String VALIDATION_MESSAGE_BELOW_RANGE = "below range";

    public static final String VALIDATION_MESSAGE_ABOVE_RANGE = "above range";

    public static final String VALIDATION_MESSAGE_INVALID_LENGTH = "invalid length";

    public static final String VALIDATION_MESSAGE_BELOW_MIN_LENGTH = "below min length";

    public static final String VALIDATION_MESSAGE_ABOVE_MAX_LENGTH = "above max length";

    public static final String VALIDATION_MESSAGE_INVALID_PRECISION = "invalid precision";

    public static final String VALIDATION_MESSAGE_BELOW_MIN_PRECISION = "below min presicion";

    public static final String VALIDATION_MESSAGE_ABOVE_MAX_PRECISION = "above max precision";

    public static final String VALIDATION_MESSAGE_INVALID_SCALE = "invalid scale";

    public static final String VALIDATION_MESSAGE_BELOW_MIN_SCALE = "below min scale";

    public static final String VALIDATION_MESSAGE_ABOVE_MAX_SCALE = "above max scale";

}
