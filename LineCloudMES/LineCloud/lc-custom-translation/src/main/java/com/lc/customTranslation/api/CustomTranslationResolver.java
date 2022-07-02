package com.lc.customTranslation.api;

import java.util.Locale;

/**
 * Service for resolving custom translation.
 *
 * @since 1.1.8
 */

public interface CustomTranslationResolver {

    /**
     * Checks if there is custom translation with given locale and is active
     *
     * @param key
     *            translation key
     * @param locale
     *            locale
     *
     * @return boolean
     */
    boolean isCustomTranslationActive(final String key, final Locale locale);

    /**
     * Gets custom translation with given locale and replaces place holders using args
     *
     * @param key
     *            translation key
     * @param locale
     *            locale
     * @param args
     *            translation args
     *
     * @return the custom translation
     */
    String getCustomTranslation(final String key, final Locale locale, final String[] args);

}
