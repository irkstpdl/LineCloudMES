package com.lc.plugin.api;

/**
 * State of the plugin.
 *
 * @since 0.1.0
 */
public enum PluginState {
    /**
     * Active in the system.
     */
    ENABLED,

    /**
     * 在系统中处于非活动状态，无需重启即可激活。
     */
    DISABLED,

    /**
     * 在系统中处于非活动状态，必须重新启动才能激活。
     */
    TEMPORARY,

    /**
     * Inactive in the system, will be activated after restart.
     */
    ENABLING,

    /**
     * 过渡状态，系统重启后数据库同步前。 此状态不能存在于已初始化的应用程序中。
     */
    UNKNOWN;
}
