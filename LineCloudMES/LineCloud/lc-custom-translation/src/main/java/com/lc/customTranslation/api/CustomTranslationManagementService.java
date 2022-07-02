package com.lc.customTranslation.api;

import java.util.List;
import java.util.Map;

import com.lc.model.api.DataDefinition;
import com.lc.model.api.Entity;

/**
 * 用于管理自定义翻译的服务。
 *
 * @since 1.1.8
 */
public interface CustomTranslationManagementService {

    /**
     * Adds custom translations with given plugin identifier, locale and key
     *
     * @param pluginIdentifier
     *            plugin identifier
     * @param locale
     *            locale
     * @param translations
     *            translation keys and values
     */
    void addCustomTranslations(final String pluginIdentifier,final String locale, final Map<String,String> translations);

    /**
     * Removes custom translations with given plugin identifier
     *
     * @param pluginIdentifier
     *            plugin identifier
     */
    void removeCustomTranslations(final String pluginIdentifier);

    /**
     * Gets list of custom translation keys with given plugin identifier
     *
     * @param pluginIdentifier
     *            plugin identifier
     *
     * @return the list of custom translation keys
     */
    List<String> getCustomTranslationKeys(final String pluginIdentifier);

    /**
     * Gets custom translation with given plugin identifier, locale and key
     *
     * @param pluginIdentifier
     *            plugin identifier
     * @param key
     *            translation key
     * @param locale
     *            locale
     *
     * @return the custom translation
     */
    Entity getCustomTranslation(final String pluginIdentifier, final String key, final String locale);

    /**
     * Gets list of custom translations with given locale
     *
     * @param locale
     *            locale
     *
     * @return the list of custom translations
     */
    List<Entity> getCustomTranslations(final String locale);

    /**
     * Gets list of custom translations
     *
     * @return the list of custom translations
     */
    List<Entity> getCustomTranslations();

    /**
     * Gets DataDefinition for model custom translation
     *
     * @return the custom translation model data definition
     */
    DataDefinition getCustomTranslationDD();

}
