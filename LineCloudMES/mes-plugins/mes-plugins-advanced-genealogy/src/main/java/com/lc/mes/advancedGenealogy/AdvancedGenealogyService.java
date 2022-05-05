package com.lc.mes.advancedGenealogy;

import java.util.Objects;
import java.util.zip.DataFormatException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lc.mes.advancedGenealogy.constants.AdvancedGenealogyConstants;
import com.lc.mes.advancedGenealogy.constants.BatchFields;
import com.lc.model.api.DataDefinition;
import com.lc.model.api.DataDefinitionService;
import com.lc.model.api.Entity;
import com.lc.model.api.search.SearchCriteriaBuilder;
import com.qcadoo.model.api.search.SearchRestrictions;

import javax.swing.text.html.parser.Entity;

@Service
public class AdvancedGenealogyService {

    @Autowired
    private DataDefinitionService dataDefinitionService;

    public Entity createOrGetBatch(final String number, final Entity product ) {
        Entity batch = getBatch(number,product);

        if (Objects.isNull(batch)) {
            return createBatch(number,product);
        }
        return batch;
    }

    public Entity createOrGetBatch ( final  String number, final Entity product, final Entity supplier) {
        Entity batch = getBatch( number,product,supplier);

        if (Objects.isNull(batch)) {
            return createBatch(number,product,supplier);
        }

        return batch;
    }

    public Entity createBatch(final String number, final Entity product) {
        return createBatch(number,product,null );
    }

    public Entity createBatch(final String number, final Entity product, final Entity supplier ) {
        Entity batch = getBatchDD().create();

        batch.setField(BatchFields.NUMBER,number);

        if (Objects.nonNull(product)) {
            batch.setField(BatchFields.PRODUCT,product.getId());
        }
        if (Objects.nonNull(supplier)) {
            batch.setField(BatchFields.SUPPLIER,supplier.getId());
        }

        return batch.getDataDefinition().save(batch);
    }


    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}