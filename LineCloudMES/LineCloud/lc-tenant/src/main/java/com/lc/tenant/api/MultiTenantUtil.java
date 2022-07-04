package com.lc.tenant.api;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultiTenantUtil {

    @Autowired
    private MultiTenantService multiTenantService;

    private static MultiTenantUtil instance;

    /**
     * Initialize utilities instance
     */
    @PostConstruct
    public void init() {
        initialise(this);
    }

    private void initialise(final MultiTenantUtil multiTenantUtil) {

        MultiTenantUtil.instance = multiTenantUtil;
    }

    /**
     * Do callback in multitenant context.
     *
     * @param callback
     */
    public static void doInMultiTenantContext(final MultiTenantCallback callback) {
        MultiTenantUtil.instance.multiTenantService.doInMultiTenantContext(callback);

    }

    /**
     * Do callback in multitenant context for given tenant id.
     *
     * @param tenantId
     * @param callback
     */
    public static void doInMultiTenantContext(final int tenantId, final MultiTenantCallback callback) {
        MultiTenantUtil.instance.multiTenantService.doInMultiTenantContext(tenantId, callback);
    }

    /**
     * Get current tenant id.
     *
     * @return tenant id
     */
    public static int getCurrentTenantId() {
        return MultiTenantUtil.instance.multiTenantService.getCurrentTenantId();
    }
}
