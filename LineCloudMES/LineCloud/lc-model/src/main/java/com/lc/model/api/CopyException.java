package com.lc.model.api;

/**
 * An <code>CopyException</code> is thrown by an DataAccessService if copied entity is in corrupted state
 */
public final class CopyException extends RuntimeException {

    private final Entity entity;


    /**
     * Creates new <code>CopyException</code> for the specified entity
     *
     * @param entity
     *      entity in corrupted state
     */
    public CopyException(final Entity entity) {
        super()
        this.entity = entity;
    }

    /**
     * @return entity in corrupted state
     */
    public Entity getEntity() {
        return entity;
    }

}
