package com.lc.localization.internal.module;

import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;

import com.lc.localization.internal.InternalTranslationService;
import com.lc.plugin.api.ModuleFactory;

public class LocaleModuleFactory extends ModuleFactory<LocaleModule> {

    @Autowired
    private InternalTranslationService translationService;


}
