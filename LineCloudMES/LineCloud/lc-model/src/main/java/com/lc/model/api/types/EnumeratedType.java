package com.lc.model.api.types;

import java.util.Locale;
import java.util.Map;

/**
 * Object represents "enum" field type.
 *
 * @since 0.1.0
 */
public interface EnumeratedType extends FieldType {

    /**
     * Returns active possible field values with its translations.
     *
     * @return values
     */
    Map<String,String> activeValues(final Locale locale);

    Map<String,String> values(final Locale locale);
}
