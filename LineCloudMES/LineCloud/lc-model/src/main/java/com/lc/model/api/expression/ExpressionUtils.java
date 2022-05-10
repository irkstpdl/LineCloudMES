package com.lc.model.api.expression;

import java.util.List;
import java.util.Locale;

import com.lc.model.api.Entity;
import com.lc.model.api.FieldDefinition;
import com.lc.model.internal.ExpressionServiceImpl;

/**
 * Utility to evaluate expression for entity.
 *
 * @version 0.1.0
 */
public final class ExpressionUtils {

    private ExpressionUtils {

    }

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
    public static String getValue(final Entity entity, final List<FieldDefinition> fields, final Locale locale) {
        return ExpressionServiceImpl.getInstance().getValue(entity, fields, locale);
    }

    /**
     * Evaluate expression value using entity fields values. Returns null when generated value is null.
     *
     * @param entity
     *            entity
     * @param locale
     *            locale
     * @return evaluated expression or null
     */
    public static String getValue(final Entity entity, final String expression, final Locale locale) {
        return ExpressionServiceImpl.getInstance().getValue(entity, expression, locale);
    }
}
