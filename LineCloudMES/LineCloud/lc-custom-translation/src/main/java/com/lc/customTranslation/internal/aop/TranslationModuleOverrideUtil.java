package com.lc.customTranslation.internal.aop;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.lc.customTranslation.api.CustomTranslationCacheService;
import com.lc.customTranslation.api.CustomTranslationManagementService;
import com.lc.customTranslation.constants.CustomTranslationContants;
import com.lc.localization.api.TranslationService;
import com.lc.plugin.api.PluginStateResolver;

@Service
public class TranslationModuleOverrideUtil {

    private static final Logger LOG = LoggerFactory.getLogger(TranslationModuleOverrideUtil.class);

    @Value("${useCustomTranslations}")

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private TranslationService translationService;

    @Autowired
    private PluginStateResolver pluginStateResolver;

    @Autowired
    private CustomTranslationManagementService customTranslationManagementService;

    @Autowired
    private CustomTranslationCacheService customTranslationCacheService;

    public boolean shouldOverride() {
        return useCustomTranslations && pluginStateResolver.isEnabled(CustomTranslationContants.PLUGIN_IDENTIFIER);
    }

    private boolean useCustomTranslations;


    public void removeTranslationKeysForPlugin(final String pluginIdentifier) {

        customTranslationManagementService.removeCustomTranslations(pluginIdentifier);

        List<String> keys = customTranslationManagementService.getCustomTranslationKeys(pluginIdentifier);

        customTranslationCacheService.removeCustomTranslations(keys);
    }

    public void addTranslationKeysForPlugin(final String pluginIdentifier, final Set<String> basenames) {
        for (String locale : translationService.getLocales().keySet()) {
            Map<String,String> translations = Maps.newHashMap();

            for (Resource resource : getPropertiesResources(basenames, locale)) {
                translations.putAll(getTranslationsFromProperties(resource));
            }

            customTranslationManagementService.addCustomTranslations(pluginIdentifier, locale, translations);

        }
    }

    private Set<Resource> getPropertiesResources(final Set<String> basenames, final String locale) {
        Set<Resource> resources = new HashSet<Resource>();

        for (String basename : basenames) {
            String searchName = basename + "_" + locale + ".properties";

            resources.add(applicationContext.getResource(searchName));
        }

        return resources;
    }

    private Map<String, String> getTranslationsFromProperties(final Resource resource) {
        Map<String, String> translations = Maps.newHashMap();

        Properties properties = new Properties();

        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;

        try {
            inputStream = resource.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);

            properties.load(inputStreamReader);

            for (Entry<Object, Object> translation : properties.entrySet()) {
                String key = (String) translation.getKey();
                String value = (String) translation.getValue();

                translations.put(key, value);
            }
        } catch (IOException e) {
            LOG.error("Can not read properties file", e);
        } finally {
            try {
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
            } catch (IOException e) {
                LOG.error("Can not close inputStreamReader", e);
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        LOG.error("Can not close inputStream", e);
                    }
                }
            }
        }

        return translations;
    }
}
