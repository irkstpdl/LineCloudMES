package com.lc.localization.internal.module;

import com.fasterxml.jackson.databind.Module;
import com.lc.localization.internal.InternalTranslationService;


public class TranslationGroupModule extends Module {

    private final InternalTranslationService translationService;

    private final String prefix;

    private final String name;

    public TranslationGroupModule(final InternalTranslationService translationService,final String prefix,final String name) {
        super();

        this.translationService =translationService;
        this.prefix = prefix;
        this.name = name;
    }

    @Override
    public void enableOnStartup() {
        translationService.prepareMessagesGroup(name,prefix);
    }

    @Override
    public void enable() {
        enableOnStartup();
    }
}
