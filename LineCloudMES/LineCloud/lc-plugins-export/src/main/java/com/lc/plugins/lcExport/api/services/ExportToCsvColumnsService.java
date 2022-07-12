package com.lc.plugins.lcExport.api.services;

import com.lc.plugins.lcExport.api.ExportToCsvColumns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Order(2)
public class ExportToCsvColumnsService implements ExportToCsvColumns {

    @Autowired
    private ExportToFileColumnsService exportToFileColumnsService;

    public List<String> getColumns(final GridComponent grid) {
        return exportToFileColumnsService.getColumns(grid);
    }
}
