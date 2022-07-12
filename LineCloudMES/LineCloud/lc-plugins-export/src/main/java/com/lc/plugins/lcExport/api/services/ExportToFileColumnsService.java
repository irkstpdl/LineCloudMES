package com.lc.plugins.lcExport.api.services;

import com.google.common.collect.Lists;
import com.lc.plugins.lcExport.api.ExportToFileColumns;
import com.lc.view.api.components.GridComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExportToFileColumnsService implements ExportToFileColumns {

    @Autowired
    private SecurityRolesService securityRolesService;

    public List<String> getColumns(final GridComponent grid) {

        List<String> columns = Lists.newLinkedList();


        grid.
    }
}
