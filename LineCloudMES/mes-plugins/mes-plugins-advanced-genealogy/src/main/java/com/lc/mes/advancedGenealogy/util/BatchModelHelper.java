package com.lc.mes.advancedGenealogy.util;

import static com.lc.model.api.search.SearchOrders.asc;
import static com.lc.model.api.search.SearchRestrictions.belongsTo;
import static com.lc.model.api.search.SearchRestrictions.eq;
import static com.lc.model.api.search.SearchRestrictions.isNull;
import static com.lc.model.api.search.SearchRestrictions.or;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lc.mes.advancedGenealogy.constants.AdvancedGenealogyConstants;
import com.lc.mes.advancedGenealogy.constants.BatchFields;
import com.lc.model.api.DataDefinition;
import com.lc.model.api.DataDefinitionService;
import com.lc.model.api.Entity;
import com.lc.model.api.search.SearchCriteriaBuilder;

@Service
public class BatchModelHelper {

    @Autowired
    private  DataDefinitionService dataDefinitionService;


}
