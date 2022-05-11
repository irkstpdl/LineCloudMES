package com.lc.model.internal.api;

import org.w3c.dom.Entity;

public interface EntityAwareEqualsPerformers extends Entity {
    boolean equals(final obj,final PerformerEntitiesChain performerEntitiesChain);

    boolean flatEquals(final Entity obj);
}
