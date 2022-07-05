package com.lc.tenant.internal;

import org.springframework.stereotype.Service;

import com.lc.tenant.api.MultiTenantCallback;
import com.lc.tenant.api.MultiTenantService;

@Service
public class DefaultMultiTenantService implements MultiTenantService {

    @Override
    public void doInMultiTenantContext(final MultiTenantCallback callback) {
        callback.invoke();
    }

    @Override
    public void doInMultiTenantContext(final int tenantId, final MultiTenantCallback callback) {
        doInMultiTenantContext(callback);
    }

    @Override
    public int getCurrentTenantId() {
        return 0;
    }
}
