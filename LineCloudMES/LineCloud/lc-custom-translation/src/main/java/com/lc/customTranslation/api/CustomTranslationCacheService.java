package com.lc.customTranslation.api;

import java.util.List;
import java.util.Map;

import com.lc.model.api.Entity;


/**
 * 用于管理自定义翻译缓存的服务。
 *
 * @since 1.0.8
 */
public interface CustomTranslationCacheService {

    /**
     * Adds custom translation with given key, locale and customTranslation
     *
     * @param key
     *            translation key
     * @param locale
     *            locale
     * @param customTranslation
     *            custom translation
     */
    void addCustomTranslation(final String key, final String locale, final String customTranslation);

    /**
     * Updates custom translation with given key, locale and customTranslation
     *
     * @param key
     *            translation key
     * @param locale
     *            locale
     * @param customTranslation
     *            custom translation
     *
     */
    void updateCustomTranslation(final String key, final String locale, final String customTranslation);

    /**
     * Manages custom translation with given key, locale and customTranslation
     *
     * @param key
     *            translation key
     * @param locale
     *            locale
     * @param customTranslation
     *            custom translation
     *
     */
    void manageCustomTranslation(final String key, final String locale, final String customTranslation);

    /**
     * Removes custom translations with given keys
     *
     * @param keys
     *            translation keys
     *
     */
    void removeCustomTranslations(final List<String> keys);

    /**
     * Gets custom translation with given key and locale
     *
     * @param key
     *            translation key
     * @param locale
     *            locale
     *
     * @return the custom translation
     */
    String getCustomTranslation(final String key, final String locale);

    /**
     * 获取自定义翻译的地图
     *
     * @return the custom translations
     */
    Map<String, Map<String, String>> getCustomTranslations();

    /**
     * 检查是否有给定键的自定义翻译
     * Checks if there is custom translation with given key
     *
     * @param key
     *            translation key
     *
     * @return boolean
     */
    boolean isCustomTranslationAdded(final String key);

    /**
     * 检查是否有给定键和语言环境的自定义翻译
     *
     * @param key
     *            translation key
     * @param locale
     *            locale
     *
     * @return boolean
     */
    boolean isCustomTranslationActive(final String key, final String locale);

    /**
     * 加载自定义翻译
     *
     * @param customTranslations
     */
    void loadCustomTranslations(final List<Entity> customTranslations);
}
