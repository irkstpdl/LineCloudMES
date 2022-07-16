package com.lc.plugins.users.internal;

import com.lc.model.api.DataDefinitionService;
import com.lc.model.api.Entity;
import com.lc.model.api.search.SearchCriteriaBuilder;
import com.lc.model.api.search.SearchRestrictions;
import com.lc.plugins.users.constants.GroupDetailsConstants;
import com.lc.security.constants.QcadooSecurityConstants;
import com.lc.view.api.components.lookup.FilterValueHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupDetailsCriteriaModifiers {

    @Autowired
    private DataDefinitionService dataDefinitionService;

    public void criteriaForGroups(final SearchCriteriaBuilder scb, final FilterValueHolder filterValue) {
        Long groupId = filterValue.getLong(GroupDetailsConstants.GROUP_ID);
        Entity group = dataDefinitionService.get(QcadooSecurityConstants.PLUGIN_IDENTIFIER, QcadooSecurityConstants.MODEL_GROUP).find().
                add(SearchRestrictions.idEq(groupId)).uniqueResult();
        List<Entity> roles = group.getManyToManyField("roles");
        for (Entity role : roles) {
            scb.add(SearchRestrictions.idNe(role.getId()));
        }
    }
}