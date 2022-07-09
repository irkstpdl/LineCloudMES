package com.lc.localization.internal;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


@Service
public class TranslationModuleService {

    private static final Logger LOG = LoggerFactory.getLogger(TranslationModuleService.class);

    @Autowired
    private ReloadableResourceBundleMessageSource messageSource;

    @Autowired
    private ApplicationContext applicationContext;

    private final Set<String> basenames = new LinkedHashSet<>();




    public void removeTranslationModule(final Collection< ? extends String> moduleBasenames) {

        basenames.removeAll(moduleBasenames);
        messageSource.clearCache();
        messageSource.setBasenames(basenames.toArray(new String[basenames.size()]));
    }

    public void addTranslationModule(final Collection<? extends String> moduleBasenames) {

        basenames.addAll(moduleBasenames);
        messageSource.clearCache();
        String[] basenamesArray = basenames.toArray(new String[basenames.size()]);
        ArrayUtils.reverse(basenamesArray);
        messageSource.setBasenames(basenamesArray);

    }

    public List<Resource> getLocalizationResources() {
        List<Resource> resources = new LinkedList<>();
        for (String basename : basenames) {
            String searchName = basename + "*.properties";
            try {
                resources.addAll(Arrays.asList(applicationContext.getResources(searchName)));
            } catch (IOException e) {
                LOG.error("Can not read messages file", e);
            }
        }
        return resources;
    }
}
