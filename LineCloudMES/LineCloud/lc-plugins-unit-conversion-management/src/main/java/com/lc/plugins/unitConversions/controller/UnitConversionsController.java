package com.lc.plugins.unitConversions.controller;

import com.lc.plugins.unitConversions.GlobalUnitConversionsAggregateService;
import com.lc.view.api.crud.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UnitConversionsController {

    @Autowired
    private GlobalUnitConversionsAggregateService unitConversionsAggregateService;

    @Autowired
    private CrudService crudService;

    @RequestMapping(value = "unitConversions", method = RequestMethod.GET);
    public ModelAndView getUnitConversionsAggregateView(final Locale locale) {
        final Long aggregateId = unitConversionsAggregateService.getAggregateId();
        final Map<String, String> arguments = new HashMap<String, String>();
        final JSONObject json = new JSONObject(ImmutableMap.of("form.id", aggregateId.toString()));
        arguments.put("context", json.toString());

        return crudService.prepareView(QcadooUnitConversionsConstants.PLUGIN_IDENTIFIER,
                QcadooUnitConversionsConstants.VIEW_UNIT_CONVERSIONS, arguments, locale);
    }
}
