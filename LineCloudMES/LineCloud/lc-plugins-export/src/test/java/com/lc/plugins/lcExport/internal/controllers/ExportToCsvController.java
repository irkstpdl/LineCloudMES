package com.lc.plugins.lcExport.internal.controllers;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.lc.model.api.aop.Monitorable;
import com.lc.model.api.file.FileService;
import com.lc.plugins.lcExport.api.ExportToCsv;
import com.lc.plugins.lcExport.api.ExportToCsvColumns;
import com.lc.plugins.lcExport.api.helpers.ExportToFileColumnsHelper;
import com.lc.view.api.ViewDefinitionState;
import com.lc.view.api.components.GridComponent;
import com.lc.view.api.crud.CrudService;
import com.lc.view.constants.LineCloudViewConstants;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class ExportToCsvController {

    private static final String L_VIEW_NAME_VARIABLE = "viewName";

    private static final String L_PLUGIN_IDENTIFIER_VARIABLE = "pluginIdentifier";

    private static final String L_CONTROLLER_PATH = "exportToCsv/{" + L_PLUGIN_IDENTIFIER_VARIABLE + "}/{" + L_VIEW_NAME_VARIABLE
            + "}";

    @Autowired
    private FileService fileService;

    @Autowired
    private CrudService crudService;

    @Autowired
    private ExportToFileColumnsHelper<ExportToCsvColumns> exportToFileColumnsHelper;

    @Autowired
    private ExportToCsv exportToCsv;

    @Monitorable(threshold = 500)
    @ResponseBody
    @RequestMapping(value = { L_CONTROLLER_PATH }, method = RequestMethod.POST)
    public Object generateCsv(@PathVariable(L_PLUGIN_IDENTIFIER_VARIABLE) final String pluginIdentifier,
                              @PathVariable(L_VIEW_NAME_VARIABLE) final String viewName, @RequestBody final JSONObject body, final Locale locale,
                              @RequestHeader("User-Agent") final String userAgent) {

        try {
            changeMaxResults(body);

            ViewDefinitionState state = crudService.invokeEvent(pluginIdentifier, viewName, body, locale);

            GridComponent grid = (GridComponent) state.getComponentByReference(QcadooViewConstants.L_GRID);

            if (grid == null) {
                JSONArray args = body.getJSONObject("event").getJSONArray("args");
                if (args.length() > 0) {
                    grid = (GridComponent) state.getComponentByReference(args.getString(0));
                }
            }

            List<String> columns = getColumns(grid);
            List<String> columnNames = getColumnNames(grid, columns);

            List<Map<String, String>> rows;

            if (grid.getSelectedEntitiesIds().isEmpty()) {
                rows = grid.getColumnValuesOfAllRecords();
            } else {
                rows = grid.getColumnValuesOfSelectedRecords();
            }

            File file = exportToCsv.createExportFile(columns, columnNames, rows, grid.getName());

            boolean openInNewWindow = !StringUtils.isNoneBlank(userAgent) || (!userAgent.contains("Chrome") && !userAgent.contains("Safari"))
                    || userAgent.contains("Edge");

            state.redirectTo(fileService.getUrl(file.getAbsolutePath()) + "?clean", openInNewWindow, false);

            return crudService.renderView(state);
        } catch (JSONException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    private List<String> getColumns(final GridComponent grid) {
        return exportToFileColumnsHelper.getColumns(grid, ExportToCsvColumns.class);
    }

    private List<String> getColumnNames(final GridComponent grid, final List<String> columns) {
        List<String> columnNames = Lists.newLinkedList();

        columns.forEach(column -> {
            String columnName = grid.getColumnNames().get(column);

            if (!Strings.isNullOrEmpty(columnName)) {
                columnNames.add(columnName);
            }
        });

        return columnNames;
    }

    private void changeMaxResults(final JSONObject json) throws JSONException {
        JSONObject component = getComponent(json, getComponentName(json));

        component.getJSONObject("content").put("firstEntity", 0);
        component.getJSONObject("content").put("maxEntities", Integer.MAX_VALUE);
    }

    private JSONObject getComponent(final JSONObject json, final String componentName) throws JSONException {
        String[] path = componentName.split("\\.");

        JSONObject component = json;

        for (String p : path) {
            component = component.getJSONObject("components").getJSONObject(p);
        }

        return component;
    }

    private String getComponentName(final JSONObject body) throws JSONException {
        return body.getJSONObject("event").getString("component");
    }

}