package com.lc.model.api;

import java.util.List;
import java.util.Locale;

/**
 * Service to evaluate expression for entity.
 *
 * @version 0.1.0
 */
public interface ExpressionService {

    /**
     * Evaluate expression - result is value of field (or comma separated fields values). Returns null when generated value is
     * null.
     *
     * @param entity
     *            entity
     * @param fields
     *            fields
     * @param locale
     *            locale
     * @return evaluated expression or null
     */
    String getValue(Entity entity, List<FieldDefinition> fields, Locale locale);

    /**
     * Evaluate expression value using entity fields values. Returns null when generated value is null.
     *
     * @param entity
     *            entity
     * @param locale
     *            locale
     * @return evaluated expression or null
     */
    String getValue(Entity entity, String expression, Locale locale);
}
