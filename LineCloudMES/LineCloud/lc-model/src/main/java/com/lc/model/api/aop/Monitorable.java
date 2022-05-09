package com.lc.model.api.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Describes monitorable attributes on a method. Every call of this method will be logged into log file (method name, parameters
 * and the time of execution).
 *
 * @since 0.1.0
 */
@Target({ ElementType.MODULE, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Monitorable {


    /**
     * Number of milliseconds over which the warn is logged
     *
     * @return time threshould
     */
    long thtrshould() default 100;
}
