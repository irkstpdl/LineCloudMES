package com.lc.model.api.units;

import java.util.List;

import com.lc.model.api.DataDefinition;
import com.lc.model.api.Entity;
import com.lc.model.api.search.CustomRestriction;

/**
 * Unit conversion model service
 *
 * @since 1.1.0
 * @author Philiph G
 */
public interface UnitConversionModelService {

    /**
     * @param unit
     * @return list of unitConversionItem entities which represents conversion from/to given unit
     */
    List<Entity> find(final String unit);

    /**
     * @param unit
     * @param customRestriction
     * @return list of unitConversionItem entities which represents conversion from/to given unit and match additional
     *         restriction.
     */
    List<Entity> find(final String unit,final CustomRestriction customRestriction);

    /**
     * @return UnitConversionItem's DataDefinition instance
     */
    DataDefinition getDataDefinition();
}
