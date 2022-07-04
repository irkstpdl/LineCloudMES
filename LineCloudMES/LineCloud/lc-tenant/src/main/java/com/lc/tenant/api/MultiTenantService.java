package com.lc.tenant.api;

public interface MultiTenantService {

    void doInMultiTenantContext(MultiTenantCallback callback);

    void doInMultiTenantContext(int tenantId, MultiTenantCallback callback);

    int  getCurrentTenantId();;
}
