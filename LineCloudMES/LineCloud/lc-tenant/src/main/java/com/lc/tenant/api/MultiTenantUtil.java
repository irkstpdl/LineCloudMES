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
     * 初始化实用程序实例
     */
    @PostConstruct
    public void init() {
        initialise(this);
    }

    private void initialise(final MultiTenantUtil multiTenantUtil) {

        MultiTenantUtil.instance = multiTenantUtil;
    }

    /**
     * 在多租户上下文中进行回调。
     *
     * @param callback
     */
    public static void doInMultiTenantContext(final MultiTenantCallback callback) {
        MultiTenantUtil.instance.multiTenantService.doInMultiTenantContext(callback);

    }

    /**
     * 在给定 tenant id的多租户上下文中执行回调。
     *
     * @param tenantId
     * @param callback
     */
    public static void doInMultiTenantContext(final int tenantId, final MultiTenantCallback callback) {
        MultiTenantUtil.instance.multiTenantService.doInMultiTenantContext(tenantId, callback);
    }

    /**
     * 获取当前租户 id.
     *
     * @return tenant id
     */
    public static int getCurrentTenantId() {
        return MultiTenantUtil.instance.multiTenantService.getCurrentTenantId();
    }
}
