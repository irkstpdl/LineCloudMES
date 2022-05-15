package com.lc.model.api.search;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
// import org.hibernate.criterion.Conjunction;
// import org.hibernate.criterion.Disjunction;
// import org.hibernate.criterion.MatchMode;
// import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lc.model.api.DataDefinition;
import com.lc.model.api.Entity;
import com.lc.model.internal.api.DataAccessService;
import com.lc.model.internal.api.InternalDataDefinition;
import com.lc.model.internal.search.InExpressionIgnoringCase;
import com.lc.model.internal.search.SearchConjunctionImpl;
import com.lc.model.internal.search.SearchCriterionImpl;
import com.lc.model.internal.search.SearchDisjunctionImpl;


public class SearchRestrictions {
    public static Object belongsTo(String fieldName, DataDefinition dataDefinition, Long id) {
    }
}
