package com.lc.view.api.utils;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.lc.model.api.DataDefinition;
import com.lc.model.api.DataDefinitionService;
import com.lc.model.api.Entity;
@Service
public class NumberGeneratorModelHelper {

    public static final String NUM_PROJECTION_ALIAS = "numProjection";

    private static final String GET_NUMBERS_QUERY_TEMPLATE = "select "
            + "distinct coalesce(trim(LEADING '0' from ${NUMBER_FIELD}), '0') as ${NUM_PROJECTION_ALIAS} "
            + "from #${PLUGIN_IDENTIFIER}_${MODEL_NAME} " + "order by ${NUM_PROJECTION_ALIAS} desc";

    private static final String GET_PREFIX_AWARE_NUMBERS_QUERY_TEMPLATE = "select "
            + "distinct trim(LEADING '0' from substring(${NUMBER_FIELD}, ${NUMBER_STARTS_AT})) as ${NUM_PROJECTION_ALIAS} "
            + "from #${PLUGIN_IDENTIFIER}_${MODEL_NAME} " + "where ${NUMBER_FIELD} like '${PREFIX}%'"
            + "order by ${NUM_PROJECTION_ALIAS} desc";

    private static final String GET_SUFFIX_AWARE_NUMBERS_QUERY_TEMPLATE = "select "
            + "distinct trim(LEADING '0' from substring(${NUMBER_FIELD}, 1, locate('${SUFFIX}', ${NUMBER_FIELD}) - 1)) as ${NUM_PROJECTION_ALIAS} "
            + "from #${PLUGIN_IDENTIFIER}_${MODEL_NAME} " + "where ${NUMBER_FIELD} like '%${SUFFIX}'"
            + "order by ${NUM_PROJECTION_ALIAS} desc";

    @Autowired
    private DataDefinitionService dataDefinitionService;

    /**
     * Returns a list of projection entities containing NUM_PROJECTION_ALIAS field with numberFieldName values with trimmed out
     * leading zeros. List is sorted descendant by numberFieldName.
     *
     * @param pluginIdentifier
     *            identifier of the plugin
     * @param modelName
     *            name of the model
     * @param numberFieldName
     *            name of the field for which number will be generated
     * @param prefix
     *            number prefix
     * @param suffix
     *            number suffix
     * @return a list of projection entities containing NUM_PROJECTION_ALIAS field with numberFieldName values with trimmed out
     *         leading zeros. List is sorted descendant by numberFieldName.
     */

    public Collection<Entity> getNumbersProjection(final String pluginIdentifier, final String modelName,
                                                   final String numberFieldName, final String prefix, final String suffix) {
        DataDefinition dd = dataDefinitionService.get(pluginIdentifier, modelName);
        String hqlQuery = buildQuery(pluginIdentifier, modelName, numberFieldName, prefix, suffix);
        return dd.find(hqlQuery).list().getEntities();
    }

    private String buildQuery(final String pluginIdentifier, final String modelName, final String numberFieldName,
                              final String prefix, final String suffix) {
        Map<String, String> placeholderValues = Maps.newHashMap();

        placeholderValues.put("PLUGIN_IDENTIFIER", pluginIdentifier);
        placeholderValues.put("MODEL_NAME", modelName);
        placeholderValues.put("NUMBER_FIELD", numberFieldName);
        placeholderValues.put("NUM_PROJECTION_ALIAS", NUM_PROJECTION_ALIAS);

        String query;
        if (StringUtils.isNotEmpty(prefix)) {
            placeholderValues.put("PREFIX", prefix);
            int prefixLength = StringUtils.length(prefix);
            placeholderValues.put("NUMBER_STARTS_AT", String.valueOf(prefixLength + 1));
            query = GET_PREFIX_AWARE_NUMBERS_QUERY_TEMPLATE;
        } else if (StringUtils.isNotEmpty(suffix)) {
            placeholderValues.put("SUFFIX", suffix);
            query = GET_SUFFIX_AWARE_NUMBERS_QUERY_TEMPLATE;
        } else {
            query = GET_NUMBERS_QUERY_TEMPLATE;
        }

        StrSubstitutor substitutor = new StrSubstitutor(placeholderValues, "${", "}");
        return substitutor.replace(query).toString();
    }

}
