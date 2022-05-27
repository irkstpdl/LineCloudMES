package com.lc.plugin.api;

/**
 * Module is a part of {@link Plugin} and represents some functionality: model, view, field, etc. Modules are instantiated by
 * {@link ModuleFactory}.
 *
 * @see Plugin plugins and modules lifecycle
 * @since 0.1.0
 */
public class Module {

    /**
     * Callback invoke once on application startup.
     */
    public void init() {
        //empty
    }

    /**
     * Callback invoke once on application startup, if plugin is enabled - in state {@link PluginState#ENABLED}.
     */
    public void enableOnStartup(){
        //empty
    }

    /**
     * Callback invoke when plugin change its state to {@link PluginState#ENABLED}.
     */
    public void enable() {
        // empty
    }

    /**
     * Callback invoke when plugin change its state from {@link PluginState#ENABLED}.
     */
    public void disable() {
        // empty
    }

    /**
     * Callback invoke once on application startup, if plugin isn't or won't be enabled - neither {@link PluginState#ENABLED} nor
     * {@link PluginState#ENABLING}.
     */
    public void disableOnStartup() {
        // empty
    }

    /**
     * Version of {@link Module#enableOnStartup()} for multi-tenant environments. Will be invoke for every tenant once. If there
     * is no tenant it won't be invoke.
     */
    public void multiTenantEnableOnStartup() {
        // empty
    }

    /**
     * Version of {@link Module#enable()} for multi-tenant environments. Will be invoke for every tenant once. If there is no
     * tenant it won't be invoke.
     */
    public void multiTenantEnable() {
        // empty
    }

    /**
     * Version of {@link Module#disable()} for multi-tenant environments. Will be invoke for every tenant once. If there is no
     * tenant it won't be invoke.
     */
    public void multiTenantDisable() {
        // empty
    }

    /**
     * Version of {@link Module#disableOnStartup()} for multi-tenant environments. Will be invoke for every tenant once. If there
     * is no tenant it won't be invoke.
     */
    public void multiTenantDisableOnStartup() {
        // empty
    }


}
