package com.lc.model.api;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * Service for getting dictionaries.
 *
 * @since 0.1.0
 */

public interface DictionaryService {

    List<String> getKey(String dictionary);

    List<String> getActiveKey(String dictionaty);

    /**
     * Return active values for given dictionary's name.
     *
     * @param dictionary
     *            dictionary's name
     * @return the dictionary's values
     */
    Map<String, String> getActiveValues(String dictionary, Locale locale);

    Map<String, String> getValue(String dictionary, Locale locale);

    Map<String, String> getKeyValues(String dictionary, Locale locale);

    /**
     * Return all defined dictionaries.
     *
     * @return the dictionaries
     */
    Set<String> getDictionaries();

    /**
     * Translate dictionary name.
     *
     * @param dictionary
     *            dictionary
     * @param locale
     *            locale
     * @return translated dictionary name
     */
    String getName(String dictionary, Locale locale);

    /**
     * Return dictionary item's entity
     *
     * @since 1.2.1
     *
     * @param dictionary
     *            dictionary's name
     * @param item
     *            dictionary item's name
     * @return dictionary item's entity
     */
    Entity getItemEntity(String dictionary,String item);

    Entity  getItemEntityByTechnicalCode(String dictionary,String technicalCode);

    Boolean checkIfUnitIsInteger(String unit);
}
