package com.lc.plugins.customTranslations.internal.hooks;

import com.lc.view.api.ViewDefinitionState;
import com.lc.view.api.components.GridComponent;
import com.lc.view.constants.LineCloudViewConstants;
import org.springframework.stereotype.Service;

@Service
public class CustomTranslationsListViewHooks {

    private static final String L_CLEAN_CUSTOM_TRANSLATIONS = "cleanCustomTranslations";

    private static final String L_CLEAN = "clean";

    public void updateRibbonState(final ViewDefinitionState view) {

        GridComponent customTranslationsGrid = (GridComponent) view.getComponentByReference(LineCloudViewConstants.L_GRID);
    }


}
