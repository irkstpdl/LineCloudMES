package com.lc.plugin.api;


import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

/**
 * Determines execution of annotated (type's) method. Run method(s) only if all specified plug-ins are enabled.
 *
 * Annotating whole class/aspect is equivalent to annotating each method/advice (also setters and getters!)
 *
 * This annotation also works with aspects. When applied to {@link Around} advice and required plug-in(s) is not enabled then
 * proceed given {@link ProceedingJoinPoint} omitting thereby execution of advice's body.
 *
 * @since 1.1.7
 * @author PhiliphG
 */

@Retention(RUNTIME)
@Target(value = {TYPE,METHOD})
public @interface RunIfEnabled {

    /**
     * Plug-in identifiers
     *
     * @return plug-in identifiers
     */
    String[] value();
}
