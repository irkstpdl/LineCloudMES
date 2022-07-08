package com.lc.localization.api;

import com.lc.localization.internal.module.LocaleModuleFactory;

import java.util.Locale;
import java.util.Map;

/**
 * 获取翻译服务。
 *
 * @since 0.4.0
 */

public interface TranslationService {

    /**
     * Default message, used when ignoreMissingTranslations is set to true and message translation was not found
     */
    String DEFAULT_MISSING_MESSAGE = "-";

    /**
     * Returns all messages (key and translation) for given group name.
     *
     * @param group
     *            group
     * @param locale
     *            prefix
     * @return messages
     */
    Map<String, String> getMessagesGroup(String group, Locale locale);

    /**
     * Translates given code into the locale using the args.
     *
     * @param code
     *            message's code
     * @param locale
     *            locale
     * @param args
     *            message's args
     * @return the translation
     */
    String translate(String code, Locale locale, String... args);

    /**
     * Translates given codes into the locale using the args. First translated code will be returned.
     *
     * @param code
     *            message's code
     * @param secondCode
     *            message's code
     * @param locale
     *            locale
     * @param args
     *            message's args
     * @return the translation
     */
    String translate(String code, String secondCode, Locale locale, String... args);

    /**
     * Translates given codes into the locale using the args. First translated code will be returned.
     *
     * @param code
     *            message's code
     * @param secondCode
     *            message's code
     * @param thirdCode
     *            message's code
     * @param locale
     *            locale
     * @param args
     *            message's args
     * @return the translation
     */
    String translate(String code, String secondCode, String thirdCode, Locale locale, String... args);

    /**
     * Returns a map of available locales.
     *
     * @return a map with a locale value and its name
     * @see LocaleModuleFactory
     */
    Map<String, String> getLocales();

    /**
     * Returns a max upload size.
     *
     * @return a max upload size
     * @see int
     */
    int getMaxUploadSize();
}
