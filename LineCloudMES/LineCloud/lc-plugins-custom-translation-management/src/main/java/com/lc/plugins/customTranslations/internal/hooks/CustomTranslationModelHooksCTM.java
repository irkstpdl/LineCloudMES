package com.lc.plugins.customTranslations.internal.hooks;

import static com.lc.customTranslation.constants.CustomTranslationFields.PLUGIN_IDENTIFIER;
import static com.lc.plugins.customTranslations.constants.CustomTranslationFieldsCTM.PLUGIN_NAME;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lc.model.api.DataDefinition;
import com.lc.model.api.Entity;
import com.lc.plugin.api.PluginAccessor;
@Service
public class CustomTranslationModelHooksCTM {

    @Autowired
    private PluginAccessor pluginAccessor;

    public void updateCustomTranslationData(final DataDefinition customTranslationDD, final Entity customTranslation) {
        String pluginIdentifier = customTranslation.getStringField(PLUGIN_IDENTIFIER);

        customTranslation.setField(PLUGIN_NAME, getPluginName(pluginIdentifier));
    }

    private String getPluginName(final String pluginIdentifier) {
        String pluginName = null;

        if (pluginIdentifier != null) {
            pluginName = pluginAccessor.getPlugin(pluginIdentifier).getPluginInformation().getName();
        }

        return pluginName;
    }
}
