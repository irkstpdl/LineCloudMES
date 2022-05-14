package com.lc.model.internal.units;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;

import com.lc.model.api.DataDefinition;
import com.lc.model.api.DataDefinitionService;
import com.lc.model.api.Entity;
import com.lc.model.api.search.CustomRestriction;
import com.lc.model.api.search.SearchCriteriaBuilder;
import com.lc.model.api.search.SearchDisjunction;
import com.lc.model.api.search.SearchRestrictions;
import com.lc.model.api.units.UnitConversionModelService;
import com.lc.model.constants.LineCloudModelConstants;
import com.lc.model.constants.UnitConversionItemFields;

@Service
public class UnitConversionModelServiceImpl implements UnitConversionModelService {

    @Autowired
    private DataDefinitionService dataDefinitionService;

    private static final OnlyGlobalConversionRestriction ONLY_GLOBAL_CONVERSION_RESTRICTION = new OnlyGlobalConversionRestriction();

    @Override
    public List<Entity> find (final String unit) {
        return find(unit,ONLY_GLOBAL_CONVERSION_RESTRICTION);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Entity> find(final String unit,final  CustomRestriction customRestriction) {
        final CustomRestriction unitMatchingRestriction = new ConversionMatchingUnitRestriction(unit,customRestriction);
        final SearchCriteriaBuilder searchCriteriaBuilder = getDataDefinition().find();
        unitMatchingRestriction.addRestriction(searchCriteriaBuilder);
        return searchCriteriaBuilder.list().getEntities();
    }
}
