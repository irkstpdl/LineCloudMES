package com.lc.plugins.lcExport.api;

import java.util.List;

import com.lc.view.api.components.GridComponent;

public interface ExportToFileColumns {

    List<String> getColumns(final GridComponent grid);
}
