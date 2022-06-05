package com.lc.plugin.api;

/**
 * Status returned by {@link PluginManager} methods.
 *
 * @since 0.1.0
 */
public enum PluginOperationStatus {

    /**
     * 插件无法启用，因为它的依赖项未启用。 需要用户决策。
     */
    DEPENDENCIES_TO_ENABLE,

    /**
     * 操作成功。
     */
    SUCCESS,

    /**
     * 操作成功，但需要重新启动。
     */
    SUCCESS_WITH_RESTART,

    /**
     * 由于缺少依赖项，无法安装或启用插件。
     */
    UNSATISFIED_DEPENDENCIES,

    /**
     * 插件不能被禁用，因为它是启用插件的依赖项。 需要用户决策。
     */
    DEPENDENCIES_TO_DISABLE,

    /**
     * 系统插件不能被禁用。
     */
    SYSTEM_PLUGIN_DISABLING,

    /**
     * 插件已成功安装，但缺少启用插件所需的依赖项。
     */
    SUCCESS_WITH_MISSING_DEPENDENCIES,

    /**
     * 插件文件已成功上传，但不是 JAR 文件或未找到描述符。
     */
    CORRUPTED_PLUGIN,

    /**
     * 无法上传插件文件。
     */
    CANNOT_UPLOAD_PLUGIN,

    /**
     * 无法安装插件 - 插件的文件不存在，无法读取或移动到目标目录。
     */
    CANNOT_INSTALL_PLUGIN_FILE,

    /**
     * 系统插件无法卸载。
     */
    SYSTEM_PLUGIN_UNINSTALLING,

    /**
     * 系统插件无法更新。
     */
    SYSTEM_PLUGIN_UPDATING,

    /**
     * 插件无法降级。
     */
    CANNOT_DOWNGRADE_PLUGIN,

    /**
     * 无法安装插件 - 存在依赖循环。
     */
    DEPENDENCIES_CYCLES_EXISTS,

    /**
     * 无法卸载插件，因为它是其他插件的依赖项。 需要用户决策。
     */
    DEPENDENCIES_TO_UNINSTALL,

    /**
     * 插件无法更新，因为它是其他插件的依赖项，并且必须禁用这些插件。
     */
    UNSATISFIED_DEPENDENCIES_AFTER_UPDATE,

    /**
     * 插件无法启用 - 已被系统管理员或商店服务禁用。
     */
    PLUGIN_ENABLING_IS_NOT_ALLOWED,

    /**
     * 由于遇到错误，无法启用插件.
     */
    PLUGIN_ENABLING_ENCOUNTERED_ERRORS,

    /**
     * 插件不存在。
     */
    PLUGIN_NOT_EXIST;

}
