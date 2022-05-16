package com.lc.view.internal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lc.model.api.aop.Monitorable;
// import com.lc.plugin.api.PluginUtils;
// import com.lc.security.api.SecurityRole;
import com.lc.view.internal.api.InternalViewDefinition;
import com.lc.view.internal.api.InternalViewDefinitionService;
import com.lc.view.internal.api.ViewDefinition;
import com.lc.view.internal.security.SecurityViewDefinitionRoleResolver;

@Service
public class ViewDefinitionServiceImpl implements InternalViewDefinitionService,SecurityViewDefinitionRoleResolver{

    private final Map<String,InternalViewDefinition> viewDefinitionMap = new HashMap<String, InternalViewDefinition>();

    @Override
    @Transactional(readOnly = true)
    @Monitorable
    @PreAuthorize("isAuthenticated() and hasPermission(#pluginIdentifier + '#' + #viewName, 'viewDefinition', 'isAuthorizedToSee')")
    public
}
