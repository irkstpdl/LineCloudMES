package com.lc.plugin.internal.aop;

import static com.lc.plugin.api.PluginUtils.isEnabled;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.lc.plugin.api.RunIfEnabled;

@Aspect
public class RunIfEnabledAspect {

    @Around("(execution(* *(..)) || (adviceexecution() && !args(org.aspectj.lang.ProceedingJoinPoint, ..))) && @annotation(annotation)")
    public Object runMethodIfEnabledAdvice(final ProceedingJoinPoint pjp, final RunIfEnabled annotation) throws Throwable {
        return runIfEnabled(pjp, null, annotation);
    }

    @Around("(execution(* *(..)) || (adviceexecution() && !args(org.aspectj.lang.ProceedingJoinPoint, ..))) && @within(annotation) && !@annotation(com.qcadoo.plugin.api.RunIfEnabled)")
    public Object runClassMethodIfEnabledAdvice(final ProceedingJoinPoint pjp, final RunIfEnabled annotation) throws Throwable {
        return runIfEnabled(pjp, null, annotation);
    }

    @Around("adviceexecution() && args(innerPjp, ..) && @annotation(annotation)")
    public Object runAroundAdviceIfEnabledAdvice(final ProceedingJoinPoint pjp, final ProceedingJoinPoint innerPjp,
                                                 final RunIfEnabled annotation) throws Throwable {
        return runIfEnabled(pjp, innerPjp, annotation);
    }

    @Around("adviceexecution() && args(innerPjp, ..) && @within(annotation) && !@annotation(com.qcadoo.plugin.api.RunIfEnabled)")
    public Object runAspectAroundIfEnabledAdvice(final ProceedingJoinPoint pjp, final ProceedingJoinPoint innerPjp,
                                                 final RunIfEnabled annotation) throws Throwable {
        return runIfEnabled(pjp, innerPjp, annotation);
    }

    private Object runIfEnabled(final ProceedingJoinPoint pjp,final ProceedingJoinPoint innerPjp,final RunIfEnabled annotation)
        throws Throwable {
        Object result = null;
        if (pluginsAreEnabled(annotation.value())) {
            result = pjp.proceed();
        } else if (innerPjp ! = null) {
            result = innerPjp.proceed();
        }
        return result;
    }

    private boolean pluginsAreEnabled(final String[] pluginIdentifiers) {
        for (String pluginIdentifier : pluginIdentifiers) {
            if (!isEnabled(pluginIdentifier)) {
                return false;
            }
        }
        return true;
    }

}
