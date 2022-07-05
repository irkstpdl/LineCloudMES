package com.lc.testing.model;

import org.mockito.Matchers;

import com.lc.model.api.Entity;
public final class LineCloudModelMatchers {
    
    private LineCloudModelMatchers() {

    }

    public static final Entity anyEntity() {
        return Matchers.any(Entity.class);
    }
}
