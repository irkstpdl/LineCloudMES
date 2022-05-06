package com.lc.mes.advancedGenealogy.constants;

import static com.lc.model.api.search.SearchRestrictions.*;

import org.apache.commons.lang3.StringUtils;

import com.lc.model.api.Entity;
import com.lc.molel.api.search.SearchCriterion;

public enum BatchNumberUniqueness {

    GLOBALLY("01globally") {

        @Override
        public SearchCriterion buildCriterionFor(final Entity batchEntity) {
            SearchCriterion numberMatches = eq(BatchFields.NUMBER, batchEntity.getStringField(BatchFields.NUMBER));
            if (batchEntity.getId() == null) {
                return numberMatches;
            }
            SearchCriterion isNotTheSameBatch = idNe(batchEntity.getId());
            return and(isNotTheSameBatch, numberMatches);
        }
    },
    SUPPLIER("02supplier") {

        @Override
        public SearchCriterion buildCriterionFor(final Entity batchEntity) {
            Entity supplier = batchEntity.getBelongsToField(BatchFields.SUPPLIER);
            return and(GLOBALLY.buildCriterionFor(batchEntity), belongsTo(BatchFields.SUPPLIER, supplier));
        }
    },
    SUPPLIER_AND_PRODUCT("03supplierAndProduct") {

        @Override
        public SearchCriterion buildCriterionFor(final Entity batchEntity) {
            Entity product = batchEntity.getBelongsToField(BatchFields.PRODUCT);
            return and(SUPPLIER.buildCriterionFor(batchEntity), belongsTo(BatchFields.PRODUCT, product));
        }
    };

    private String stringValue;

    private BatchNumberUniqueness(final String stringValue) {
        this.stringValue = stringValue;
    }

    public abstract SearchCriterion buildCriterionFor(final Entity batchEntity);

    public String getStringValue() {
        return stringValue;
    }

    public static final BatchNumberUniqueness parseString(final String stringToParse) {
        if (StringUtils.isBlank(stringToParse)) {
            return null;
        }
        for (BatchNumberUniqueness numberUniquenessValue : values()) {
            if (numberUniquenessValue.getStringValue().equalsIgnoreCase(stringToParse)) {
                return numberUniquenessValue;
            }
        }
        return null;
    }
}