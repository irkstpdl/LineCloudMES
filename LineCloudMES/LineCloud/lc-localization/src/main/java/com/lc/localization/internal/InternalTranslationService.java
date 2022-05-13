package com.lc.localization.internal;

import com.lc.localization.api.TranslationService;

/**
 * Service for getting translations.
 */
public interface InternalTranslationService  extends TranslationService {

    void prepareMessagesGroup(String group,String prefix);

    void addLocaleToList(String locale,String label);

    void removeLocaleToList(String locale);
}
