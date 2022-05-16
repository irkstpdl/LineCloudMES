package com.lc.view.internal.api;

import java.util.Locale;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.lc.view.api.ViewDefinitionState;
import com.lc.view.internal.components.window.WindowComponentPattern;
import com.lc.view.internal.hooks.AbstractViewHookDefinition;

public interface InternalViewDefinition extends  ViewDefinition {

    String JSON_EVENT = "event";

    String JSON_EVENT_NAME = "name";

    String JSON_EVENT_COMPONENT = "component";

    String JSON_EVENT_ARGS = "args";

    String JSON_COMPONENTS = "components";

    String JSON_JS_FILE_PATHS = "jsFilePaths";

    Map<String,Object> prepareView(JSONObject jsonObject,Locale locale);

    ViewDefinitionState performEvent(JSONObject jsonObject,Locale locale) throws JSONException;

    boolean isMenuAccessible();

    void addJsFilePath(String jsFilePath);

    void registerComponent(String reference, String path, ComponentPattern pattern);

    void unregisterComponent(String reference, String path);

    String translateContextReferences(String context);

    void addHook(AbstractViewHookDefinition viewHookDefinition);

    void removeHook(AbstractViewHookDefinition viewHookDefinition);

    WindowComponentPattern getRootWindow();

    ComponentPattern getComponentByReference(String reference);

    void addComponentPattern(final ComponentPattern componentPattern);

    void initialize();
}
