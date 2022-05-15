package com.lc.model.api.search;

/**
 * A sequence of {@link SearchCriterion} linked using conjunction - (... AND ... AND ...).
 *
 * @version 0.1.1
 */
public interface SearchConjunction  extends SearchCriterion {

    /**
     * Adds criterion to this conjunction.
     *
     * @param criterion
     *            criterion
     */
    void add(final SearchCriterion criterion);

}
