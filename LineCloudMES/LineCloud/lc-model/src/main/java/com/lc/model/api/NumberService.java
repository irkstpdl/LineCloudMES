package com.lc.model.api;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Service to provide utilities for numbers
 *
 * @version 1.1.3
 */
public interface NumberService {

    /**
     * Default maximum number of fraction digits in decimal number
     *
     * @since 1.2.1
     */
    int DEFAULT_MAX_FRACTION_DIGITS_IN_DECIMAL = 5;

    /**
     * Default maximum number of fraction digits in decimal number
     *
     * @since 1.2.1
     */
    int DEFAULT_MIN_FRACTION_DIGITS_IN_DECIMAL = 2;

    /**
     * Default maximum number of integer digits in decimal number
     *
     * @since 1.2.1
     */
    int DEFAULT_MAX_INTEGER_DIGITS_IN_DECIMAL = 7;

    /**
     * Default maximum number of digits in integer number
     *
     * @since 1.2.1
     */
    int DEFAULT_MAX_DIGITS_IN_INTEGER = 10;

    /**
     * Provide global MathContext.
     *
     * @return {@link MathContext}
     */
    MathContext getMathContext();

    /**
     * Formats an object with DecimalFormat to produce a String.
     *
     * @param obj
     *
     * @return Formatted string.
     */
    String format(final Object obj);

    /**
     * Set default (currently 5) decimal's scale (number of digits after coma) using default RoundingMode.
     *
     * @param decimal
     *
     * @return BigDecimal with default scale (currently 5).
     */
    BigDecimal  setScaleWithDefaultMathContext(final BigDecimal decimal);

    /**
     * Set given decimal's scale (number of digits after coma) using default RoundingMode.
     *
     * @param decimal
     *
     * @return BigDecimal with scale 5.
     */
    BigDecimal setScaleWithDefaultMathContext(final BigDecimal decimal, final int newScale);

    /**
     * Formats an object with DecimalFormat to produce a String.
     *
     * @param obj
     * @param minimumFractionDigits
     *
     * @return Formatted string.
     */
    String formatWithMinimumFractionDigits(Object obj,int minimumFractionDigits);
}
