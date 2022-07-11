package com.lc.view.api;

import com.google.common.base.Optional;
import org.json.JSONObject;

import java.util.Map;

/**
 * ViewDefinitionState 是单个视图的实例。 它是在请求范围内使用 ViewDefinition 生成的。
 *
 * 它包含此视图的所有 {@link com.lc.view.api.ComponentState ComponentStates}
 * 以及向客户端显示此视图所需的其他数据。 更改其数据也将更改显示给系统用户的状态。
 *
 * @since 0.1.0
 *
 * @see com.lc.view.api.ComponentState
 */
public interface ViewDefinitionState extends ComponentState{

    /**
     * 返回具有指定引用名称的组件状态，如果未找到此类组件，则返回 null
     * @param reference
     *            组件的参考名称
     * @return 具有指定引用名称的组件状态
     */
     ComponentState getComponentByReference(String reference);


    /**
     * 返回 Optional 包含具有指定引用名称的组件，如果没有找到此类组件或找到的组件的类型不是要求的，
     * 则返回空 Optional（请参阅 T 类型参数）。
     * @since 1.1
     * @param reference
     *            组件的参考名称
     * @return 包含在 Optional 中的指定引用名称的组件状态，或者 Optional.absent() 如果没有找到此类组件或找到的组件具有其他类型而不是要求的类型。
     */
    <T extends ComponentState> Optional<T> tryFindComponentByReference(String reference);

    /**
     * 通知客户端应该重定向到某个 url。
     *
     * @param redirectToUrl
     *            重定向的目标url
     * @param openInNewWindow
     *            如果客户端应该在新窗口中打开给定的 url，则为 true
     * @param shouldSerialize
     *            如果在此重定向客户端之前应该保存窗口状态，则为 true
     */
    void redirectTo(String redirectToUrl, boolean openInNewWindow, boolean shouldSerialize);

    /**
     * 通知客户端应该重定向到某个 url 并传递自定义组件参数。
     *
     * @param redirectToUrl
     *            重定向的目标url
     * @param openInNewWindow
     *            如果客户端应该在新窗口中打开给定的 url，则为 true
     * @param shouldSerialize
     *            如果在此重定向客户端之前应该保存窗口状态，则为 true
     * @param parameters
     *            在视图之间传递的参数映射
     */
    void redirectTo(String redirectToUrl, boolean openInNewWindow, boolean shouldSerialize, Map<String, Object> parameters);

    /**
     * 通知客户端应该打开新的模式窗口。
     *
     * @param url
     *            打开窗口的目标 url
     */
    void openModal(String url);

    /**
     * 通知客户端应该打开新的模态窗口并传递自定义组件参数。
     *
     * @param url
     *            打开窗口的目标 url
     */
    void openModal(String url, Map<String, Object> parameters);

    /**
     * 检查视图是第一次生成还是重新加载后生成
     *
     * @return boolean
     */
    boolean isViewAfterReload();

    /**
     * 检查视图是否在重定向事件后生成
     * @return boolean
     */
    boolean isViewAfterRedirect();

    /**
     * 设置上下文表单 url
     *
     * @param jSONObject
     */
    void setJsonContext(JSONObject jSONObject);

    /**
     * 从 url 获取上下文
     *
     * @return
     */
    JSONObject getJsonContext();

}
