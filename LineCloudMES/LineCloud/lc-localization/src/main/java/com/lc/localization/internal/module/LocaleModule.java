package com.lc.localization.internal.module;

import com.lc.localization.internal.InternalTranslationService;
import com.lc.plugin.api.Module;

public class LocaleModule extends Module {

    private final InternalTranslationService translationService;

    private final String locale;

    private final String label;


    public LocaleModule(final InternalTranslationService translationService, final String locale, final String label) {
        super();

        this.translationService = translationService;
        this.locale = locale;
        this.label = label;
    }

    @Override
    public void enableOnStartup() {
        enable();
    }

    @Override
    public void enable() {
        translationService.addLocaleToList(locale, label);
    }

    @Override
    public void disable() {
        translationService.removeLocaleToList(locale);
    }
}
