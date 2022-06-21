package com.lc.plugins.lcExport.api.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import com.lc.plugins.lcExport.api.ExportToPdfColumns;
import com.lc.view.api.components.GridComponent;

@Service
@Order(2)
public class ExportToPdfColumnsService implements ExportToPdfColumns {

    @Autowired
    private ExportToFileColumnsService exportToFileColumnsService;

    public List<String> getColumns(final GridComponent grid) {
        return exportToFileColumnsService.getColumns(grid);
    }
}
