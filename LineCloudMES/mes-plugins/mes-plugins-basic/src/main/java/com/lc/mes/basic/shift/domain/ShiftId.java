package com.lc.mes.basic.shift.domain;

import com.lc.mes.basic.domain.ImmutableIdWrapper;

public final class ShiftId extends ImmutableIdWrapper {

    public ShiftId(final Long id) {
        super(id);
    }

    @Override
    public String toString() {
        return String.format("ShiftId(%s)" ,get());
    }
}
