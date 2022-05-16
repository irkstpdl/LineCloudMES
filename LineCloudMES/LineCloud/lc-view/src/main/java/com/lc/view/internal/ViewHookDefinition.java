package com.lc.view.internal;

import java.lang.reflect.Method;

/**
 * Defines hooks for validation/saving entities and generating views.
 */
public interface ViewHookDefinition {

    Object getBean();

    Method getMethod();

    String getPluginIdentifier();

}
