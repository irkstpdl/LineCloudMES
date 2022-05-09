package com.lc.mes.advancedGenealogy.hooks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lc.mes.advancedGenealogy.states.constants.BatchState;
import com.lc.mes.advancedGenealogy.states.constants.BatchStateChangeDescriber;
import com.lc.mes.states.service.StateChangeEntityBuilder;

import com.lc.model.api.DataDefinition;
import com.lc.model.api.Entity;
import com.lc.model.api.search.SearchRestrictions;

@Service
public class BatchModelHooks {

    @Autowired
    private StateChangeEntityBuilder stateChangeEntityBuilder;
    
    @Autowired
    private BatchStateChangeDescriber batchStateChangeDescriber;

    public void setIn

}
