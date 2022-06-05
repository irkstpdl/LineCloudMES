package com.lc.plugin.internal.aop;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import com.lc.plugin.api.RunIfEnabled;

public class RunIfEnabledAspectTest {

    @Test
    public final void checkPointcutDeclarations() {
        assertEquals("com.lc.plugin.api.RunIfEnabled", RunIfEnabled.class.getCanonicalName());
    }
}
