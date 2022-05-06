package com.lc.mes.advancedGenealogy.util;

import com.lc.mes.advancedGenealogy.constants.AdvancedGenealogyConstants;
import com.lc.mes.advancedGenealogy.constants.BatchFields;
import com.lc.model.api.DataDefinition;
import com.lc.model.api.Entity;
import com.lc.model.api.FieldDefinition;
import com.lc.model.api.types.BelongsToType;

import javax.swing.text.html.parser.Entity;


/**
 * Util for common batch operations, like extracting batch number from belongsTo batch field.
 */

public class BatchUtil {

    private BatchUtil() {

        /**
         * Tries to extract the batch's number.
         *
         * @param entity
         *            entity from which you want to extract batch's number
         * @param batchFieldName
         *            name of the belongsTo field pointing to the batch entity
         * @return batch number as a String or null if given entity is null or batch field is null.
         * @throws IllegalArgumentException
         *             if given field name doesn't correspond to belongs to field pointing to the batch model.
         */

    }

    public  static String extractNumberForm(final Entity entity,final String batchFieldName) {
        return getBatchField(entity,batchFieldName,BatchFields.NUMBER);
    }

    /**
     * Tries to extract the batch's external number.
     *
     * @param entity
     *            entity from which you want to extract batch's external number
     * @param batchFieldName
     *            name of the belongsTo field pointing to the batch entity
     * @return batch external number as a String or null if given entity is null or batch field is null.
     * @throws IllegalArgumentException
     *             if given field name doesn't correspond to belongs to field pointing to the batch model.
     */

    public static String extractExernaNumberForm(final Entity entity, final String batchFieldName) {
        return getBatchField(entity,batchFieldName,BatchFields.EXTERNAL_NUMBER);
    }

    private static <T> T getBatchField(final Entity entity,final String batchFieldName,final String batchProperty ) {
        Entity batchOrNull = getBatchForm(entity,batchFieldName);
        if (batchOrNull == null) {
            return null;
        }

        return (T) batchOrNull.getField(batchProperty);
    }

    private static Entity getBatchForm(final Entity entity,final  String batchFieldName) {
        if (entity == null) {
            return null;
        }
        checkField(entity.getDataDefinition(),batchFieldName);
        return entity.getBelongsToField(batchFieldName);

    }

    private static void checkField(final DataDefinition dateDef,final String fieldName) {
        FieldDeFinition fd = dateDef.getField(fieldName);
        if (fd.getType() instanceof BelongsToType) {
            BelongsToType btType =(BelongsToType) fd.getType();
            DataDefinition dd = btType.getDataDefinition();
            if (AdvancedGenealogyConstants.PLUGIN_IDENTIFIER.equals(dd.getPluginIdentifier())
                && AdvancedGenealogyConstants.MODEL_BATCH.equals(dd.getName())) {
                return;
            }
        }

        throw new IllegalArgumentException(String.format(
                "Field '%s' should be of type belongsTo, pointing to the advanced genealogy's batch entity!", fieldName
        ));
    }
}
