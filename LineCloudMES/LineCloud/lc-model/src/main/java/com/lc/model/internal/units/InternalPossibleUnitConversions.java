package com.lc.model.internal.units;

import com.lc.model.api.units.PossibleUnitConversions;
import com.lc.model.api.units.UnitConversion;

public interface InternalPossibleUnitConversions extends PossibleUnitConversions {

    void addConversion(final UnitConversion unitConversion);
}
