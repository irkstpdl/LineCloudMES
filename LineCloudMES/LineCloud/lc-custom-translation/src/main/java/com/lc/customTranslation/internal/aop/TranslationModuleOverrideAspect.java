package com.lc.customTranslation.internal.aop;

import java.util.Set;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.lc.customTranslation.constants.CustomTranslationContants;
import com.lc.localization.api.TranslationPropertiesHolder;
import com.lc.plugin.api.RunIfEnabled;


@Aspect
@Configurable
@RunIfEnabled(CustomTranslationContants.PLUGIN_IDENTIFIER)
public class TranslationModuleOverrideAspect {

    @Autowired
    private TranslationModuleOverrideUtil translationModuleOverrideUtil;

    @Pointcut("execution(public void com.lc.localization.internal.module.TranslationModule.multiTenantEnable(..)) "
            + "&& target(translationPropertiesHolder)")
    public void enableExecution(final TranslationPropertiesHolder translationPropertiesHolder) {
    }

    @AfterReturning("enableExecution(translationPropertiesHolder)")
    public void afterReturningEnableExecution(final TranslationPropertiesHolder translationPropertiesHolder) throws Throwable {
        if (translationModuleOverrideUtil.shouldOverride()) {
            String pluginIdentifier = translationPropertiesHolder.getPluginIdentifier();
            Set<String> basenames = translationPropertiesHolder.getParsedBasenames();

            translationModuleOverrideUtil.addTranslationKeysForPlugin(pluginIdentifier, basenames);
        }
    }

    @Pointcut("execution(public void com.lc.localization.internal.module.TranslationModule.multiTenantDisable(..)) "
            + "&& this(translationPropertiesHolder)")
    public void disableExecution(final TranslationPropertiesHolder translationPropertiesHolder) {
    }

    @AfterReturning("disableExecution(translationPropertiesHolder)")
    public void afterReturningDisableExecution(final TranslationPropertiesHolder translationPropertiesHolder) throws Throwable {
        if (translationModuleOverrideUtil.shouldOverride()) {
            String pluginIdentifier = translationPropertiesHolder.getPluginIdentifier();

            translationModuleOverrideUtil.removeTranslationKeysForPlugin(pluginIdentifier);
        }
    }
}
