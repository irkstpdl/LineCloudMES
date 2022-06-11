package com.lc.localization.internal.module;

import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;

import com.lc.localization.internal.InternalTranslationService;
import com.lc.plugin.api.ModuleFactory;

public class TranslationGroupModuleFactory extends ModuleFactory<TranslationGroupModule> {

    @Autowired
    private InternalTranslationService translationService;

    @Override
    protected TranslationGroupModule parseElement(final String pluginIdentifier, final Element element) {
        String prefix = getRequiredAttribute(element, "prefix");
        String name = getRequiredAttribute(element, "name");

        return new TranslationGroupModule(translationService, prefix, name);
    }

    @Override
    public String getIdentifier() {
        return "translation-group";
    }

}