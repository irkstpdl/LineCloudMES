package com.lc.model.internal.units.hooks;

import org.springframework.stereotype.Service;

import com.lc.model.api.DataDefinition;
import com.lc.model.api.Entity;
import com.lc.model.constants.UnitConversionItemFields;

@Service
public class UnitConversionItemValidators {

    public boolean validateUnits(final DataDefinition dataDefinition ,final Entity unitConversionItem ) {
        String unitForm =unitConversionItem.getStringField(UnitConversionItemFields.UNIT_FROM);
        String unitTo = unitConversionItem.getStringField(UnitConversionItemFields.UNIT_TO);
        if (unitForm.equals(unitTo)) {
            unitConversionItem.addError(dataDefinition.getField(UnitConversionItemFields.UNIT_TO),
                    "LineCloudUnitConversions.unitConversionItem.validateError.theSameUnit");
            return false;

        }
        return true;
    }


}
